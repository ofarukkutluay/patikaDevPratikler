
using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using Microsoft.EntityFrameworkCore;
using WebApi.Common;
using WebApi.DbOperations;

namespace WebApi.Application.BookOperations.Queries.GetBookDetail
{
    public class GetBookDetailQuery
    {
        public int BookId { get; set; }
        private readonly BookStoreDbContext _dbContext;
        private readonly IMapper _mapper;
        public GetBookDetailQuery(BookStoreDbContext dbContext, IMapper mapper)
        {
            _dbContext = dbContext;
            _mapper = mapper;
        }

        public BookDetailViewModel Handle()
        {
            var book = _dbContext.Books.Include(x=>x.Genre).Where(x => x.Id == BookId).SingleOrDefault();
            if(book is null)
                throw new InvalidOperationException("Kayıt bulunamadı!");

            BookDetailViewModel vm = _mapper.Map<BookDetailViewModel>(book); // new BookDetailViewModel
            // {
            //     Title = book.Title,
            //     PageCount = book.PageCount,
            //     Genre = ((GenreEnum)book.GenreId).ToString(),
            //     PublishDate = book.PublishDate.Date.ToString("dd/MM/yyyy")
            // };

            return vm;
        }
    }

    public class BookDetailViewModel
    {
        public string Title { get; set; }
        public int PageCount { get; set; }
        public string PublishDate { get; set; }
        public string Genre { get; set; }
    }

}