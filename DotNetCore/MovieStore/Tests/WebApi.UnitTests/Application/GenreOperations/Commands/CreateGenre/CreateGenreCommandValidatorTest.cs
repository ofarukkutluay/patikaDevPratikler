using System;
using System.Linq;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.GenreOperations.Commands.CreateGenre;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.GenreOperations.Commands.CreateGenre
{
    public class CreateGenreCommandValidatorTest : IClassFixture<CommonTestFixture>
    {

        [Theory]
        [InlineData("a")]
        [InlineData("")]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors(string name){
            CreateGenreCommand command = new CreateGenreCommand(null,null);
            command.Model = new CreateGenreViewModel{
                Name = name
            };

            CreateGenreCommandValidator validator = new CreateGenreCommandValidator();
            var result = validator.Validate(command);

            result.Errors.Count.Should().BeGreaterThan(0);

        }
        
        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            CreateGenreCommand command = new CreateGenreCommand(null,null);
            command.Model = new CreateGenreViewModel{
                Name = "ValidGenre"
            };

            CreateGenreCommandValidator validator = new CreateGenreCommandValidator();
            var result = validator.Validate(command);

            result.Errors.Count.Should().Be(0);
        }
    }
}