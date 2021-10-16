using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Commands.UpdateGenre;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Commands.UpdateGenre
{
    public class UpdateGenreCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Theory]
        [InlineData("",0)]
        [InlineData("Lor",1)]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors(string name, int id)
        {
            //arrange
            UpdateGenreCommand command = new UpdateGenreCommand(null);
            command.GenreId = id;
            command.Model = new UpdateGenreModel(){
                Name = name,
            };  

            //act        
            UpdateGenreCommandValidator validator = new UpdateGenreCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }


        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            UpdateGenreCommand command = new UpdateGenreCommand(null);
            command.GenreId=1;
            command.Model = new UpdateGenreModel(){
                Name="title"
            };  

            //act        
            UpdateGenreCommandValidator validator = new UpdateGenreCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}