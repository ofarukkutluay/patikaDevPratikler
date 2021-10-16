using System;
using AutoMapper;
using FluentAssertions;
using Tests.WebApi.UnitTests.TestSetup;
using WebApi.Application.AuthorOperations.Commands.UpdateAuthor;
using WebApi.DbOperations;
using WebApi.Entities;
using Xunit;

namespace Tests.WebApi.UnitTests.Application.AuthorOperations.Commands.UpdateAuthor
{
    public class UpdateAuthorCommandValidatorTests : IClassFixture<CommonTestFixture>
    {
        [Theory]
        [InlineData("Lo","lo",0)]
        [InlineData("","",1)]
        [InlineData("loo","lo",0)]
        [InlineData("l","looo",1)]
        public void WhenInvalidInputAreGiven_Validator_ShouldBeReturnErrors(string firstName,string lastName,int id)
        {
            //arrange
            UpdateAuthorCommand command = new UpdateAuthorCommand(null);
            command.AuthorId = id;
            command.Model = new UpdateAuthorModel(){
                FirstName=firstName,LastName=lastName,DayOfBirth=DateTime.Now.Date.AddYears(-10)
            };  

            //act        
            UpdateAuthorCommandValidator validator = new UpdateAuthorCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().BeGreaterThan(0);
        }


        [Fact]
        public void WhenValidInputAreGiven_Validator_ShouldNotReturnError(){
            //arrange
            UpdateAuthorCommand command = new UpdateAuthorCommand(null);
            command.AuthorId=1;
            command.Model = new UpdateAuthorModel(){
                FirstName="TestYazar",LastName="TestYazarSoyadı",DayOfBirth=DateTime.Now.Date.AddYears(-10)
            };  

            //act        
            UpdateAuthorCommandValidator validator = new UpdateAuthorCommandValidator();
            var result = validator.Validate(command); 

            //assert
            result.Errors.Count.Should().Be(0);

        }
    }
}