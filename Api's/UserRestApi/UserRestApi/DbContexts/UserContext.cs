using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserRestApi.Entities;

namespace UserRestApi.DbContexts
{
    public class UserContext : DbContext
    {
        public UserContext(DbContextOptions<UserContext> options) :
            base(options)
        {
        }

        public DbSet<User> Users { get; set; }
        public DbSet<UserInformation> UsersInformation { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>().HasData(new User
            {
                Id = Guid.Parse("b780cc58-533c-4286-b449-0e98b040c958"),
                UserName = "BogdanPricepere",
                Email = "procepere@gmail.com",
                Password = "Password"
            },
            new User
            {
                Id = Guid.Parse("b780cc58-533c-4286-b449-0e98b040c859"),
                UserName = "BogdanPricepere",
                Email = "procepere@gmail.com",
                Password = "Password"
            });

            base.OnModelCreating(modelBuilder);
        }
    }
}
