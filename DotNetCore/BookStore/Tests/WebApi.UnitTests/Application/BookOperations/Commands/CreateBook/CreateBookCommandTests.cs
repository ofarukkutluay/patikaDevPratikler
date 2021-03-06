using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Commands.CreateBook;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Commands.CreateBook
{
    public class CreateBookCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public CreateBookCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenAlreadyExistBookTitleIsGiven_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var book = new Book { Title = "Test_WhenAlreadyExistBookTitleIsGiven_InvalidOperationException_ShouldBeReturn", PageCount = 100, PublishDate = DateTime.Now.AddYears(-10).Date, GenreId = 1, AuthorId = 1 };
            _context.Books.Add(book);
            _context.SaveChanges();

            CreateBookCommand command = new CreateBookCommand(_context, _mapper);
            command.Model = new CreateBookModel() { Title = book.Title ,PageCount=book.PageCount,AuthorId=book.AuthorId,GenreId=book.GenreId,PublishDate=book.PublishDate};

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Kitap Zaten Mevcut!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Book_ShouldBeCreated()
        {
            //arrange (Hazırlık)
            CreateBookCommand command = new CreateBookCommand(_context, _mapper);
            var model = new CreateBookModel() { Title = "hobbit", PageCount = 100, PublishDate = DateTime.Now.Date.AddYears(-10), AuthorId = 1, GenreId = 1 };
            command.Model = model;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var book = _context.Books.FirstOrDefault(book => book.Title == model.Title);
            book.Should().NotBeNull();
            book.PageCount.Should().Be(model.PageCount);
            book.PublishDate.Should().Be(model.PublishDate);
            book.GenreId.Should().Be(model.GenreId);
            book.AuthorId.Should().Be(model.AuthorId);
        }
    }
}