using System;
using WebApi.DbOperations;
using WebApi.Entities;

namespace Tests.WebApi.UnitTests.TestSetup
{
    public static class Authors
    {

        public static void AddAuthors(this BookStoreDbContext context)
        {
            context.Authors.AddRange(
                    new Author
                    {
                        FirstName = "Yazar",
                        LastName = "YazarSoyadı",
                        DayOfBirth = new DateTime(1993, 06, 12)
                    },
                    new Author
                    {
                        FirstName = "Yazar2",
                        LastName = "Yazar2Soyadı",
                        DayOfBirth = new DateTime(1890, 01, 21)
                    },
                    new Author
                    {
                        FirstName = "Yazar3",
                        LastName = "Yazar3Soyadı",
                        DayOfBirth = new DateTime(2001, 04, 30)
                    }
                );
        }

    }


}