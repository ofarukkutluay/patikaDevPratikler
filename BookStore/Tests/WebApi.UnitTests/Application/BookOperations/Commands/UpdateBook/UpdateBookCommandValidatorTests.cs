using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Commands.UpdateBook;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Commands.UpdateBook
{
    public class UpdateBookCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Theory]
        [InlineData("Lord Of the",0,0,0)]
        [InlineData("Lord Of the",0,1,0)]
        [InlineData("Lord Of the",0,0,1)]
        [InlineData("Lord Of the",100,0,0)]
        [InlineData("",0,0,0)]
        [InlineData("",100,0,0)]
        [InlineData("",0,1,0)]
        [InlineData("",0,0,1)]
        [InlineData("Lor",100,1,1)]
        [InlineData("lord",0,0,0)]
        [InlineData("lord",100,0,0)]
        [InlineData("lord",0,1,0)]
        [InlineData("lord",0,0,1)]
        [InlineData(" ",100,1,1)]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors(string title, int pageCount, int genreId,int authorId)
        {
            //arrange
            UpdateBookCommand command = new UpdateBookCommand(null);
            command.Model = new UpdateBookModel(){
                Title = title,
                PageCount = pageCount,
                PublishDate = DateTime.Now.Date.AddYears(-1),
                GenreId = genreId,
                AuthorId = authorId
            };  

            //act        
            UpdateBookCommandValidator validator = new UpdateBookCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }

        [Fact]
        public void WhenDatetimeEqualNowIsGiven_Validator_ShouldBeReturnError(){
            //arrange
            UpdateBookCommand command = new UpdateBookCommand(null);
            command.Model = new UpdateBookModel(){
                Title = "title",
                PageCount = 100,
                PublishDate = DateTime.Now.Date,
                GenreId = 1,
                AuthorId = 1
            };  

            //act        
            UpdateBookCommandValidator validator = new UpdateBookCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);

        }

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            UpdateBookCommand command = new UpdateBookCommand(null);
            command.Model = new UpdateBookModel(){
                Title = "title",
                PageCount = 100,
                PublishDate = DateTime.Now.Date.AddYears(-2),
                GenreId = 1,
                AuthorId = 1
            };  

            //act        
            UpdateBookCommandValidator validator = new UpdateBookCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}