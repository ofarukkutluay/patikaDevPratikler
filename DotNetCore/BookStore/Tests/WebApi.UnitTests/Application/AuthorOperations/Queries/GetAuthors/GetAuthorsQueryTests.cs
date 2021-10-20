using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Microsoft.EntityFrameworkCore;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Queries.GetAuthors;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Queries.GetAuthors
{
    public class GetAuthorsQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetAuthorsQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValid_Authors_ShouldBeGet()
        {
            //arrange (Hazırlık)
            GetAuthorsQuery query = new GetAuthorsQuery(_context,_mapper);

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => query.Handle())
                .Invoke();

            //assert (Doğrulama)
            var AuthorList = _context.Authors.ToList<Author>();
            List<AuthorsViewModel> vm = _mapper.Map<List<AuthorsViewModel>>(AuthorList);
            vm.Should();
            
        }

    }
}