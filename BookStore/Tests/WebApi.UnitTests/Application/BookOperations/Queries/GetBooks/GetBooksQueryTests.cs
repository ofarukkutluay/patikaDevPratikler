using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Microsoft.EntityFrameworkCore;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Queries.GetBooks;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Queries.GetBooks
{
    public class GetBooksQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetBooksQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValid_Books_ShouldBeGet()
        {
            //arrange (Hazırlık)
            GetBooksQuery query = new GetBooksQuery(_context,_mapper);

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => query.Handle())
                .Invoke();

            //assert (Doğrulama)
            var bookList = _context.Books.Include(x=>x.Genre).Include(x=>x.Author).OrderBy(x => x.Id).ToList<Book>();
            List<BooksViewModel> vm = _mapper.Map<List<BooksViewModel>>(bookList);
            vm.Should();
            
        }

    }
}