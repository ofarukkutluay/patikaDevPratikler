using System;
using System.Linq;
using WebApi.DbOperations;
using WebApi.Entities;

namespace WebApi.Application.AuthorOperations.Commands.UpdateAuthor
{
    public class UpdateAuthorCommand
    {
        public int AuthorId { get; set; }
        public UpdateAuthorModel Model { get; set; }
        private readonly IBookStoreDbContext _dbContext;

        public UpdateAuthorCommand(IBookStoreDbContext dbContext)
        {
            _dbContext = dbContext;
        }
        public void Handle()
        {
            var author = _dbContext.Authors.SingleOrDefault(x => x.Id == AuthorId);
            if (author is null)
                throw new InvalidOperationException("Yazar bulunamadı!");
            

            author.FirstName = !string.IsNullOrEmpty(Model.FirstName.Trim()) ? Model.FirstName : author.FirstName;
            author.LastName = !string.IsNullOrEmpty(Model.LastName.Trim()) ? Model.LastName : author.LastName;
            author.DayOfBirth = Model.DayOfBirth != default ? Model.DayOfBirth : author.DayOfBirth;
            _dbContext.SaveChanges();
        }
    }

    public class UpdateAuthorModel
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime DayOfBirth { get; set; }
    }
}