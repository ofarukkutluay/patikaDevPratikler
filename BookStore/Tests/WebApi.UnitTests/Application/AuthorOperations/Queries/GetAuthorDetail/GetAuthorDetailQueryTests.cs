using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Queries.GetAuthorDetail;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Queries.GetAuthorDetail
{
    public class GetAuthorDetailQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetAuthorDetailQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValidInputAreGiven_Author_ShouldBeGetDetail()
        {
            //arrange (Hazırlık)
            Author model = new Author { FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.Date.AddYears(-10) };
            _context.Authors.Add(model);
            _context.SaveChanges();
            int AuthorId = _context.Authors.FirstOrDefault(x => x.FullName == model.FullName).Id;

            GetAuthorDetailQuery query = new GetAuthorDetailQuery(_context, _mapper);
            query.AuthorId = AuthorId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => query.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchAuthor = _context.Authors.FirstOrDefault(x => x.FullName == model.FullName);
            searchAuthor.Should().NotBeNull();
            searchAuthor.FirstName.Should().Be(model.FirstName);
            searchAuthor.LastName.Should().Be(model.LastName);
            searchAuthor.DayOfBirth.Should().Be(model.DayOfBirth);

        }

        [Fact]
        public void WhenInvalidInputId_Author_ShouldBeGetDetail()
        {

            int lastAuthorId = _context.Authors.Last().Id;

            GetAuthorDetailQuery query = new GetAuthorDetailQuery(_context, _mapper);
            query.AuthorId = lastAuthorId + 1;



            FluentActions
                .Invoking(() => query.Handle()).Should()
                .Throw<InvalidOperationException>().And.Message
                .Should()
                .Be("Yazar bulunamadı!");
        }

    }
}