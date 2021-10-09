

using System.Collections.Generic;
using System.Linq;
using WebApi.Common;
using WebApi.DbOperations;

namespace WebApi.BookOperations.GetBook
{
    public class GetBookQuery
    {
        public int BookId { get; set; }
        private readonly BookStoreDbContext _dbContext;
        public GetBookQuery(BookStoreDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public BooksViewModel Handle()
        {
            var book = _dbContext.Books.Where(x => x.Id == BookId).SingleOrDefault();
            BooksViewModel vm = new BooksViewModel
            {
                Title = book.Title,
                PageCount = book.PageCount,
                Genre = ((GenreEnum)book.GenreId).ToString(),
                PublishDate = book.PublishDate.Date.ToString("dd/MM/yyyy")
            };

            return vm;
        }
    }

    public class BooksViewModel
    {
        public string Title { get; set; }
        public int PageCount { get; set; }
        public string PublishDate { get; set; }
        public string Genre { get; set; }
    }

}