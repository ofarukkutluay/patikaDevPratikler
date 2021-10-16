using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Commands.UpdateAuthor;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Commands.UpdateAuthor
{
    public class UpdateAuthorCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;

        public UpdateAuthorCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
        }

        [Fact]
        public void WhenAlreadyExistAuthorTitleIsGiven_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var authorId = _context.Authors.Max(x=>x.Id);

            UpdateAuthorCommand command = new UpdateAuthorCommand(_context);
            command.AuthorId = authorId+1;

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Yazar bulunamadı!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Author_ShouldBeUpdated()
        {
            //arrange (Hazırlık)
            int lastAuthorId = _context.Authors.Last().Id;
            UpdateAuthorCommand command = new UpdateAuthorCommand(_context);
            var model = new UpdateAuthorModel() { FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.Date.AddYears(-10)  };
            command.AuthorId = lastAuthorId;
            command.Model = model;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var author = _context.Authors.SingleOrDefault(author => author.Id == lastAuthorId);
            author.Should().NotBeNull();
            author.FirstName.Should().Be(model.FirstName);
            author.LastName.Should().Be(model.LastName);
            author.DayOfBirth.Should().Be(model.DayOfBirth);

        }
    }
}