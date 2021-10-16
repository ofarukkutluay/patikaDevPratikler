using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Commands.DeleteGenre;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Commands.DeleteGenre
{
    public class DeleteGenreCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;

        public DeleteGenreCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
        }

        [Fact]
        public void WhenAlreadyExistGenre_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var maxGenreId = _context.Genres.ToList().Max(x=> x.Id);

            DeleteGenreCommand command = new DeleteGenreCommand(_context);
            command.GenreId = maxGenreId+1;

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Kitap türü bulunamadı!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Genre_ShouldBeDeleted()
        {
            //arrange (Hazırlık)
            var Genre = new Genre { Name = "hobbit" };
            _context.Genres.Add(Genre);
            _context.SaveChanges();

            var maxGenreId = _context.Genres.SingleOrDefault(x=>x.Name == Genre.Name).Id;
            
            DeleteGenreCommand command = new DeleteGenreCommand(_context);
            command.GenreId = maxGenreId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchGenre = _context.Genres.FirstOrDefault(Genre => Genre.Id == maxGenreId);
            searchGenre.Should().BeNull();
        }
    }
}