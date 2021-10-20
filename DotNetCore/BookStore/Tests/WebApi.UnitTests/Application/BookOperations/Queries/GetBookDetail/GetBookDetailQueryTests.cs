using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Queries.GetBookDetail;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Queries.GetBookDetail
{
    public class GetBookDetailQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetBookDetailQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValidInputAreGiven_Book_ShouldBeGetDetail()
        {
            //arrange (Hazırlık)
            Book model = new Book { Title = "Test_WhenValidInputAreGiven_Book_ShouldBeGetDetail", PageCount = 100, PublishDate = DateTime.Now.Date.AddYears(-10), GenreId = 1, AuthorId = 1 };
            _context.Books.Add(model);
            _context.SaveChanges();
            int bookId = _context.Books.FirstOrDefault(x => x.Title == model.Title).Id;

            GetBookDetailQuery query = new GetBookDetailQuery(_context, _mapper);
            query.BookId = bookId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => query.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchBook = _context.Books.FirstOrDefault(x => x.Title == model.Title);
            searchBook.Should().NotBeNull();
            searchBook.PageCount.Should().Be(model.PageCount);
            searchBook.PublishDate.Should().Be(model.PublishDate);
            searchBook.GenreId.Should().Be(model.GenreId);
            searchBook.AuthorId.Should().Be(model.AuthorId);

        }

        [Fact]
        public void WhenInvalidInputId_Book_ShouldBeGetDetail()
        {

            int lastBookId = _context.Books.Last().Id;

            GetBookDetailQuery query = new GetBookDetailQuery(_context, _mapper);
            query.BookId = lastBookId + 1;



            FluentActions
                .Invoking(() => query.Handle()).Should()
                .Throw<InvalidOperationException>().And.Message
                .Should()
                .Be("Kayıt bulunamadı!");
        }

    }
}