using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using System.Linq;
using WebApi.DbOperations;
using WebApi.Application.BookOperations.Queries.GetBooks;
using WebApi.Application.BookOperations.Commands.CreateBook;
using WebApi.Application.BookOperations.Commands.UpdateBook;
using WebApi.Application.BookOperations.Queries.GetBookDetail;
using WebApi.Application.BookOperations.Commands.RemoveBook;
using AutoMapper;
using FluentValidation.Results;
using FluentValidation;
using Microsoft.AspNetCore.Authorization;

namespace WebApi.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]s")]
    public class BookController : ControllerBase
    {
        private readonly IBookStoreDbContext _context;
        private readonly IMapper _mapper;

        public BookController(IBookStoreDbContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }



        // private static List<Book> BookList = new List<Book>(){
        //     new Book{
        //         Id=1,
        //         Title="Lean Startup",
        //         GenreId = 1,
        //         PageCount = 200,
        //         PublishDate= new DateTime(2001,06,12)
        //     },
        //     new Book{
        //         Id=2,
        //         Title="Herland",
        //         GenreId = 2,
        //         PageCount = 250,
        //         PublishDate= new DateTime(2010,05,23)
        //     },
        //     new Book{
        //         Id=3,
        //         Title="une",
        //         GenreId = 2,
        //         PageCount = 540,
        //         PublishDate= new DateTime(2001,12,21)
        //     },
        // };

        [HttpGet]
        public IActionResult GetBooks()
        {
            GetBooksQuery query = new GetBooksQuery(_context, _mapper);
            var result = query.Handle();
            return Ok(result);

        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            GetBookDetailQuery query = new GetBookDetailQuery(_context, _mapper);
            // try
            // {
            query.BookId = id;
            GetBookDetailQueryValidator validator = new GetBookDetailQueryValidator();
            validator.ValidateAndThrow(query);
            var result = query.Handle();
            return Ok(result);
            // }
            // catch (System.Exception ex)
            // {
            //     return BadRequest(ex.Message);
            // }


        }

        // [HttpGet]
        // public Book Get([FromQuery]int id){
        //     var book = BookList.Where(x=> x.Id==id).SingleOrDefault();
        //     return book;
        // }

        [HttpPost]
        public IActionResult AddBook([FromBody] CreateBookModel newBook)
        {
            CreateBookCommand command = new CreateBookCommand(_context, _mapper);
            // try
            // {
            command.Model = newBook;
            CreateBookCommandValidator validator = new CreateBookCommandValidator();
            // ValidationResult result = validator.Validate(command);
            // if (!result.IsValid)
            // {

            //     foreach (var item in result.Errors)
            //     {
            //         Console.WriteLine($"Özellik : {item.PropertyName} - Error Message: {item.ErrorMessage} ");
            //     }
            //     return BadRequest(result);
            // }else
            // {
            //     command.Handle();
            // }

            validator.ValidateAndThrow(command);
            command.Handle();

            // }
            // catch (Exception ex)
            // {
            //     return BadRequest(ex.Message);
            // }
            return Ok();
        }

        [HttpPut("{id}")]
        public IActionResult UpdateBook(int id, [FromBody] UpdateBookModel updatedBook)
        {
            UpdateBookCommand command = new UpdateBookCommand(_context);
            // try
            // {
            command.BookId = id;
            command.Model = updatedBook;
            UpdateBookCommandValidator validator = new UpdateBookCommandValidator();
            validator.ValidateAndThrow(command);
            command.Handle();
            // }
            // catch (Exception ex)
            // {
            //     return BadRequest(ex.Message);
            // }
            return Ok();
        }

        [HttpDelete("{id}")]
        public IActionResult RemoveBook(int id)
        {
            RemoveBookCommand command = new RemoveBookCommand(_context);
            // try
            // {
            command.BookId = id;
            RemoveBookCommandValidator validator = new RemoveBookCommandValidator();
            validator.ValidateAndThrow(command);
            command.Handle();
            // }
            // catch (Exception ex)
            // {
            //     return BadRequest(ex.Message);
            // }
            return Ok();
        }



    }

}