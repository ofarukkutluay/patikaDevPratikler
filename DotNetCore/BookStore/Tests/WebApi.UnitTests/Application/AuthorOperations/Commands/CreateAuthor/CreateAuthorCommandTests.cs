using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Commands.CreateAuthor;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Commands.CreateAuthor
{
    public class CreateAuthorCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;
        private readonly IMapper _mapper;

        public CreateAuthorCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
            _mapper = testFixture.Mapper;
        }

        [Fact]
        public void WhenAlreadyExistAuthorNameIsGiven_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var author = new Author { FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.AddYears(-10).Date};
            _context.Authors.Add(author);
            _context.SaveChanges();

            CreateAuthorCommand command = new CreateAuthorCommand(_context,_mapper);
            command.Model = new CreateAuthorModel() { FirstName=author.FirstName,LastName=author.LastName,DayOfBirth=author.DayOfBirth };

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Yazar zaten mevcut!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Author_ShouldBeCreated()
        {
            //arrange (Hazırlık)
            CreateAuthorCommand command = new CreateAuthorCommand(_context,_mapper);
            var model = new CreateAuthorModel() { FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.AddYears(-10).Date };
            command.Model = model;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var author = _context.Authors.FirstOrDefault(author => author.FirstName == model.FirstName);
            author.Should().NotBeNull();
            author.FirstName.Should().Be(model.FirstName);
            author.LastName.Should().Be(model.LastName);
            author.DayOfBirth.Should().Be(model.DayOfBirth);
        }
    }
}