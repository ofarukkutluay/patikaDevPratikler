

using System;
using System.Collections.Generic;
using System.Linq;
using WebApi.Common;
using WebApi.DbOperations;

namespace WebApi.Application.BookOperations.Commands.RemoveBook
{
    public class RemoveBookCommand
    {
        public int BookId {get;set;}
        private readonly IBookStoreDbContext _dbContext;
        public RemoveBookCommand(IBookStoreDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void Handle(){
            var book = _dbContext.Books.SingleOrDefault(x => x.Id == BookId);
            if (book is null)
                throw new InvalidOperationException("Kayıt bulunamadı!");

            _dbContext.Books.Remove(book);
            _dbContext.SaveChanges();

        }


    }

}