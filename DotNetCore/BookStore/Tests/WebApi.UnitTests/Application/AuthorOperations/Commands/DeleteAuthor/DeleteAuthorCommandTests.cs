using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Commands.DeleteAuthor;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Commands.DeleteAuthor
{
    public class DeleteAuthorCommandTests : IClassFixture<CommonTestFixture>
    {
        private readonly BookStoreDbContext _context;

        public DeleteAuthorCommandTests(CommonTestFixture testFixture)
        {
            _context = testFixture.Context;
        }

        [Fact]
        public void WhenAlreadyExistAuthor_InvalidOperationException_ShouldBeReturn()
        {
            //arrange (Hazırlık)
            var maxAuthorId = _context.Authors.Max(x=> x.Id);

            DeleteAuthorCommand command = new DeleteAuthorCommand(_context);
            command.AuthorId = maxAuthorId+1;

            //act (Çalıştırma) && //assert (Doğrulama)

            FluentActions
                .Invoking(() => command.Handle())
                .Should().Throw<InvalidOperationException>().And.Message.Should().Be("Yazar bulunamadı!");
        }

        [Fact]
        public void WhenValidInputAreGiven_Author_ShouldBeDeleted()
        {
            //arrange (Hazırlık)
            var author = new Author { FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.AddYears(-10).Date };
            _context.Authors.Add(author);
            _context.SaveChanges();

            var maxAuthorId = _context.Authors.SingleOrDefault(x=>x.FirstName == author.FirstName).Id;
            
            DeleteAuthorCommand command = new DeleteAuthorCommand(_context);
            command.AuthorId = maxAuthorId;

            //act (Çalıştırma) 

            FluentActions
                .Invoking(() => command.Handle())
                .Invoke();

            //assert (Doğrulama)
            var searchAuthor = _context.Authors.FirstOrDefault(Author => Author.Id == maxAuthorId);
            searchAuthor.Should().BeNull();
        }
    }
}