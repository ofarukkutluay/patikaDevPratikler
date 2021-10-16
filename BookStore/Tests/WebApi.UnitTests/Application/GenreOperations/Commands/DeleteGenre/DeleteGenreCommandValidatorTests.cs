using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Commands.DeleteGenre;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Commands.DeleteGenre
{
    public class DeleteGenreCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Fact]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors()
        {
            //arrange
            DeleteGenreCommand command = new DeleteGenreCommand(null);
            command.GenreId = 0; 

            //act        
            DeleteGenreCommandValidator validator = new DeleteGenreCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }

        

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            DeleteGenreCommand command = new DeleteGenreCommand(null);
            command.GenreId = 1;  

            //act        
            DeleteGenreCommandValidator validator = new DeleteGenreCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}