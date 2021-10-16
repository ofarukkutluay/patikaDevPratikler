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
    public class GetGenreDetailQueryTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public GetGenreDetailQueryTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenValidInputAreGiven_Genre_ShouldBeGetDetail()
        {
            //arrange (Hazırlık)
            Genre model = new Genre { Name="Tools" };
            _context.Genres.Add(model);
            _context.SaveChanges();
            int genreId = _context.Genres.FirstOrDefault(x => x.Name == model.Name).Id;

            GetGenreDetailQuery query = new GetGenreDetailQuery(_context, _mapper);
            query.GenreId = genreId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => query.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchGenre = _context.Genres.FirstOrDefault(x => x.Name == model.Name);
            searchGenre.Should().NotBeNull();
            searchGenre.Name.Should().Be(model.Name);
            searchGenre.IsActive.Should().Be(model.IsActive);

        }

        [Fact]
        public void WhenInvalidInputId_Genre_ShouldBeGetDetail()
        {

            int lastGenreId = _context.Genres.Last().Id;

            GetGenreDetailQuery query = new GetGenreDetailQuery(_context, _mapper);
            query.GenreId = lastGenreId + 1;



            FluentActions
                .Invoking(() => query.Handle()).Should()
                .Throw<InvalidOperationException>().And.Message
                .Should()
                .Be("Kayıt bulunamadı!");
        }

    }
}