using System;
using WebApi.DbOperations;
using WebApi.Entities;

namespace Tests.WebApi.UnitTests.TestSetup
{
    public static class Genress
    {
        public static void AddGenres(this BookStoreDbContext context)
        {
            context.Genres.AddRange(
                    new Genre{Name = "Personel Growth"},
                    new Genre{Name = "Science Fiction"},
                    new Genre{Name = "Romance"}
                );
        }
    }

}