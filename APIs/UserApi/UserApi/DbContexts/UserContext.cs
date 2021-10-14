using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserApi.Entities;

namespace UserApi.Controllers
{
    public class UserContext : DbContext
    {
        public UserContext(DbContextOptions<UserContext> options)
            :base(options)
        {

        }

        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>().HasData(new User()
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564247"),
                UserName = "BerceaSmen",
                Password = "MyPass",
                Gender = Gender.Male
            },
            new User()
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564248"),
                UserName = "Luiji",
                Password = "LuijiPass",
                Gender = Gender.Male
            },
            new User()
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564249"),
                UserName = "Alexut",
                Password = "AlexutPass",
                Gender = Gender.Male
            },
            new User()
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564243"),
                UserName = "Johnut",
                Password = "JohnutPass",
                Gender = Gender.Female
            }
            );

            base.OnModelCreating(modelBuilder);
        }
    }
}
