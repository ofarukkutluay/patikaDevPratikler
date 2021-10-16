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
    public class GetBookDetailValidatorQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetBookDetailValidatorQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldBeGetDetail()
        {
            //arrange (Hazırlık)

            GetBookDetailQuery query = new GetBookDetailQuery(null, null);
            query.BookId = 1;

            //act (Çalıştırma) 

            GetBookDetailQueryValidator validator = new GetBookDetailQueryValidator();
            var result = validator.Validate(query);


            //assert (Doğrulama)
            result.Errors.Count.Should().Be(0);

        }

        [Fact]
        public void WhenInvalidInputId_Validator_ShouldBeGetDetail()
        {


            GetBookDetailQuery query = new GetBookDetailQuery(_context, _mapper);
            query.BookId = 0;
            //act (Çalıştırma) 

            GetBookDetailQueryValidator validator = new GetBookDetailQueryValidator();
            var result = validator.Validate(query);


            //assert (Doğrulama)
            result.Errors.Count.Should().BeGreaterThan(0);

        }

    }
}