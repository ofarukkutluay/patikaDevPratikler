

using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using WebApi.Common;
using WebApi.DbOperations;
using WebApi.Entities;

namespace WebApi.Application.BookOperations.Commands.CreateBook
{
    public class CreateBookCommand
    {
        public CreateBookModel Model {get;set;}
        private readonly BookStoreDbContext _dbContext;
        private readonly IMapper _mapper;
        public CreateBookCommand(BookStoreDbContext dbContext, IMapper mapper)
        {
            _dbContext = dbContext;
            _mapper = mapper;
        }

        public void Handle(){
            var book = _dbContext.Books.SingleOrDefault(x => x.Title.ToLower() == Model.Title.ToLower());
            if (book is not null)
                throw new InvalidOperationException("Kitap Zaten Mevcut!");
            book = _mapper.Map<Book>(Model);  // new Book();
            // book.Title = Model.Title;
            // book.PublishDate = Model.PublishDate;
            // book.PageCount = Model.PageCount;
            // book.GenreId = Model.GenreId;

            _dbContext.Books.Add(book);
            _dbContext.SaveChanges();

        }


    }

    public class CreateBookModel{
        public string  Title { get; set; }
        public int GenreId { get; set; }
        public int PageCount { get; set; }
        public DateTime PublishDate { get; set; }
        public int AuthorId { get; set; }
    }
}