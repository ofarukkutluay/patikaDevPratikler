

using System;
using System.Collections.Generic;
using System.Linq;
using AutoMapper;
using Microsoft.Extensions.Configuration;
using Webapi.TokenOperations;
using WebApi.Common;
using WebApi.DbOperations;
using WebApi.Entities;
using WebApi.TokenOperations.Models;

namespace WebApi.Application.TokenOperations.Commands.RefreshToken
{
    public class RefreshTokenCommand
    {
        public string RefreshToken { get; set; }
        private readonly IBookStoreDbContext _dbContext;
        private readonly IConfiguration _configuration;
        public RefreshTokenCommand(IBookStoreDbContext dbContext, IConfiguration configuration)
        {
            _dbContext = dbContext;
            _configuration = configuration;
        }

        public Token Handle()
        {
            var user = _dbContext.Users.FirstOrDefault(x=>x.RefreshToken == RefreshToken  && x.RefresTokenExpireDate>DateTime.Now);
            if(user is null)
                throw new InvalidOperationException("Valid bir refresh token bulunamadı!");
            
            TokenHandler handler = new TokenHandler(_configuration);
            Token token = handler.CreateAccessToken(user);

            user.RefreshToken = token.RefreshToken;
            user.RefresTokenExpireDate = token.Expiration.AddMinutes(5);
            _dbContext.SaveChanges();

            return token;

        }


    }

}