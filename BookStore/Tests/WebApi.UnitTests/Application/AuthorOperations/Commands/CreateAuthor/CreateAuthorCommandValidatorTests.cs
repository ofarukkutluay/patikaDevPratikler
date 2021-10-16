using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Commands.CreateAuthor;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Commands.CreateAuthor
{
    public class CreateAuthorCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Theory]
        [InlineData("Lo","lo")]
        [InlineData("","")]
        [InlineData("loo","lo")]
        [InlineData("l","looo")]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors(string firstName,string lastName)
        {
            //arrange
            CreateAuthorCommand command = new CreateAuthorCommand(null,null);
            command.Model = new CreateAuthorModel(){
                FirstName=firstName,LastName=lastName,DayOfBirth=DateTime.Now.Date.AddYears(-10)
            };  

            //act        
            CreateAuthorCommandValidator validator = new CreateAuthorCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }

        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            CreateAuthorCommand command = new CreateAuthorCommand(null,null);
            command.Model = new CreateAuthorModel(){
                FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.Date.AddYears(-10)
                
            };  

            //act        
            CreateAuthorCommandValidator validator = new CreateAuthorCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}