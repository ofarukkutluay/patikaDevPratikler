using System;
using System.Linq;
using WebApi.DbOperations;
using WebApi.Entities;

namespace WebApi.Application.AuthorOperations.Commands.DeleteAuthor
{
    public class DeleteAuthorCommand
    { 
        public int AuthorId { get; set; }
        private readonly BookStoreDbContext _dbContext;

        public DeleteAuthorCommand(BookStoreDbContext dbContext)
        {
            _dbContext = dbContext;
        }
        public void Handle(){
            var author = _dbContext.Authors.SingleOrDefault(x=>x.Id==AuthorId);
            if(author is null)
                throw new InvalidOperationException("Yazar bulunamadı!");
            var books = _dbContext.Books.Where(x=> x.AuthorId == AuthorId);
            if(books is not null)
                throw new InvalidOperationException("Yazarın kitapları bulunmaktadır. Önce Yazara ait kitapları siliniz!");
            _dbContext.Authors.Remove(author);
            _dbContext.SaveChanges();
        }
    }


}