﻿using FoodApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FoodApi.DbContexts
{
    public class FoodContext : DbContext
    {
        public FoodContext(DbContextOptions<FoodContext> options)
            :base(options)
        {

        }

        public DbSet<Aliment> Alimets { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Aliment>().HasData(new Aliment {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564247"),
                Name = "Macaroane",
                CaloriesPer1Gram = 2,
                ProteinPer1Gram = 1,
                FatPer1Gram = 1,
                CarbohidratesPer1Gram = 3
            },
            new Aliment
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564274"),
                Name = "Lapte",
                CaloriesPer1Gram = 2,
                ProteinPer1Gram = 1,
                FatPer1Gram = 1,
                CarbohidratesPer1Gram = 3
            },
            new Aliment
            {
                Id = Guid.Parse("6b1eea43-5597-45a6-bdea-e68c60564435"),
                Name = "Oua",
                CaloriesPer1Gram = 2,
                ProteinPer1Gram = 1,
                FatPer1Gram = 1,
                CarbohidratesPer1Gram = 3
            }
            );

            base.OnModelCreating(modelBuilder);
        }
    }
}
