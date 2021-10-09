using System;
using FluentValidation;

namespace WebApi.BookOperations.RemoveBook
{
    public class RemoveBookCommandValidator : AbstractValidator<RemoveBookCommand>
    {
        public RemoveBookCommandValidator()
        {
            RuleFor(command => command.BookId).GreaterThan(0);

        }
    }
}