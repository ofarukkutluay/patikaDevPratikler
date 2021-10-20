using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.BookOperations.Commands.RemoveBook;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.BookOperations.Commands.RemoveBook
{
    public class RemoveBookCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Fact]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors()
        {
            //arrange
            RemoveBookCommand command = new RemoveBookCommand(null);
            command.BookId = 0; 

            //act        
            RemoveBookCommandValidator validator = new RemoveBookCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }

        

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            RemoveBookCommand command = new RemoveBookCommand(null);
            command.BookId = 1;  

            //act        
            RemoveBookCommandValidator validator = new RemoveBookCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}