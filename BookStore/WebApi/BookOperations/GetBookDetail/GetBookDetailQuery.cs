
using System;
using System.Collections.Generic;
using System.Linq;
using WebApi.Common;
using WebApi.DbOperations;

namespace WebApi.BookOperations.GetBookDetail
{
    public class GetBookDetailQuery
    {
        public int BookId { get; set; }
        private readonly BookStoreDbContext _dbContext;
        public GetBookDetailQuery(BookStoreDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public BooksDetailViewModel Handle()
        {
            var book = _dbContext.Books.Where(x => x.Id == BookId).SingleOrDefault();
            if(book is null)
                throw new InvalidOperationException("Kayıt bulunamadı!");
                
            BooksDetailViewModel vm = new BooksDetailViewModel
            {
                Title = book.Title,
                PageCount = book.PageCount,
                Genre = ((GenreEnum)book.GenreId).ToString(),
                PublishDate = book.PublishDate.Date.ToString("dd/MM/yyyy")
            };

            return vm;
        }
    }

    public class BooksDetailViewModel
    {
        public string Title { get; set; }
        public int PageCount { get; set; }
        public string PublishDate { get; set; }
        public string Genre { get; set; }
    }

}