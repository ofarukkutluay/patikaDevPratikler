using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Commands.UpdateGenre;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Commands.UpdateGenre
{
    public class UpdateGenreCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;

        public UpdateGenreCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
        }

        [Fact]
        public void WhenAlreadyExistGenreTitleIsGiven_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var genre = new Genre { Name = "title" };
            _context.Genres.Add(genre);
            _context.SaveChanges();

            UpdateGenreCommand command = new UpdateGenreCommand(_context);
            command.Model = new UpdateGenreModel() { Name = genre.Name };

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Aynı isimde bir kitap türü zaten mevcut!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Genre_ShouldBeUpdated()
        {
            //arrange (Hazırlık)
            UpdateGenreCommand command = new UpdateGenreCommand(_context);
            var model = new UpdateGenreModel() { Name="title" };
            command.Model = model;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var Genre = _context.Genres.SingleOrDefault(Genre => Genre.Name == model.Name);
            Genre.Should().NotBeNull();
            Genre.Name.Should().Be(model.Name);
            Genre.IsActive.Should().Be(model.IsActive);

        }
    }
}