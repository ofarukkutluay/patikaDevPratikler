
using FluentValidation;

namespace WebApi.Application.AuthorOperations.Commands.UpdateAuthor
{
    public class UpdateAuthorCommandValidator : AbstractValidator<UpdateAuthorCommand>
    {
        public UpdateAuthorCommandValidator()
        {
            RuleFor(command => command.Model.FirstName).MinimumLength(2).When(x=> x.Model.FirstName.Trim() != string.Empty);
            RuleFor(command => command.Model.LastName).MinimumLength(2).When(x=> x.Model.LastName.Trim() != string.Empty);
            RuleFor(command => command.Model.DayOfBirth).LessThan(System.DateTime.Now.Date).When(x=> x.Model.FirstName.Trim() != string.Empty);
            RuleFor(command => command.AuthorId).GreaterThan(0);
        }
    }
}