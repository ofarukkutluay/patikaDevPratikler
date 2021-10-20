using System;
using FluentValidation;

namespace WebApi.Application.BookOperations.Commands.RemoveBook
{
    public class RemoveBookCommandValidator : AbstractValidator<RemoveBookCommand>
    {
        public RemoveBookCommandValidator()
        {
            RuleFor(command => command.BookId).GreaterThan(0);

        }
    }
}