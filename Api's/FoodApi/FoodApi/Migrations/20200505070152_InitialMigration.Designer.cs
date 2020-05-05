﻿// <auto-generated />
using System;
using FoodApi.DbContexts;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace FoodApi.Migrations
{
    [DbContext(typeof(FoodContext))]
    [Migration("20200505070152_InitialMigration")]
    partial class InitialMigration
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "3.0.1")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("FoodApi.Entities.Aliment", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<int>("CaloriesPer1Gram")
                        .HasColumnType("int");

                    b.Property<int>("CarbohidratesPer1Gram")
                        .HasColumnType("int");

                    b.Property<int>("FatPer1Gram")
                        .HasColumnType("int");

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("nvarchar(100)")
                        .HasMaxLength(100);

                    b.Property<int>("ProteinPer1Gram")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.ToTable("Alimets");

                    b.HasData(
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"),
                            CaloriesPer1Gram = 2,
                            CarbohidratesPer1Gram = 3,
                            FatPer1Gram = 1,
                            Name = "Macaroane",
                            ProteinPer1Gram = 1
                        },
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564274"),
                            CaloriesPer1Gram = 2,
                            CarbohidratesPer1Gram = 3,
                            FatPer1Gram = 1,
                            Name = "Lapte",
                            ProteinPer1Gram = 1
                        },
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564435"),
                            CaloriesPer1Gram = 2,
                            CarbohidratesPer1Gram = 3,
                            FatPer1Gram = 1,
                            Name = "Oua",
                            ProteinPer1Gram = 1
                        });
                });
#pragma warning restore 612, 618
        }
    }
}
