using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Queries.GetGenreDetail;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Queries.GetGenreDetail
{
    public class GetGenreDetailValidatorQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetGenreDetailValidatorQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldBeGetDetail()
        {
            //arrange (Hazırlık)

            GetGenreDetailQuery query = new GetGenreDetailQuery(null, null);
            query.GenreId = 1;

            //act (Çalıştırma) 

            GetGenreDetailQueryValidator validator = new GetGenreDetailQueryValidator();
            var result = validator.Validate(query);


            //assert (Doğrulama)
            result.Errors.Count.Should().Be(0);

        }

        [Fact]
        public void WhenInvalidInputId_Validator_ShouldBeGetDetail()
        {


            GetGenreDetailQuery query = new GetGenreDetailQuery(_context, _mapper);
            query.GenreId = 0;
            //act (Çalıştırma) 

            GetGenreDetailQueryValidator validator = new GetGenreDetailQueryValidator();
            var result = validator.Validate(query);


            //assert (Doğrulama)
            result.Errors.Count.Should().BeGreaterThan(0);

        }

    }
}