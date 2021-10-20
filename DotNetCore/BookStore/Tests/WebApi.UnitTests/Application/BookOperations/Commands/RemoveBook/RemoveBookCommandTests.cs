using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Commands.RemoveBook;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Commands.RemoveBook
{
    public class RemoveBookCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;

        public RemoveBookCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
        }

        [Fact]
        public void WhenAlreadyExistBook_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var maxBookId = _context.Books.ToList().Max(x=> x.Id);

            RemoveBookCommand command = new RemoveBookCommand(_context);
            command.BookId = maxBookId+1;

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Kayıt bulunamadı!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Book_ShouldBeRemoved()
        {
            //arrange (Hazırlık)
            var book = new Book { Title = "hobbit", PageCount = 100, PublishDate = new DateTime(1990, 01, 10), GenreId = 1, AuthorId = 1 };
            _context.Books.Add(book);
            _context.SaveChanges();

            int maxBookId = _context.Books.SingleOrDefault(x=>x.Title == book.Title).Id;
            
            RemoveBookCommand command = new RemoveBookCommand(_context);
            command.BookId = maxBookId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchBook = _context.Books.SingleOrDefault(book => book.Id == maxBookId);
            searchBook.Should().BeNull();
        }
    }
}