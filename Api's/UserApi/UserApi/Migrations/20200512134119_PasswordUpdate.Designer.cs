﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using UserApi.Controllers;

namespace UserApi.Migrations
{
    [DbContext(typeof(UserContext))]
    [Migration("20200512134119_PasswordUpdate")]
    partial class PasswordUpdate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "3.0.1")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("UserApi.Entities.User", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<int>("Age")
                        .HasColumnType("int");

                    b.Property<int>("Gender")
                        .HasColumnType("int");

                    b.Property<double>("Height")
                        .HasColumnType("float");

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("UserName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<double>("Weight")
                        .HasColumnType("float");

                    b.HasKey("Id");

                    b.ToTable("Users");

                    b.HasData(
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"),
                            Age = 0,
                            Gender = 0,
                            Height = 0.0,
                            Password = "MyPass",
                            UserName = "BerceaSmen",
                            Weight = 0.0
                        },
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564248"),
                            Age = 0,
                            Gender = 0,
                            Height = 0.0,
                            Password = "LuijiPass",
                            UserName = "Luiji",
                            Weight = 0.0
                        },
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564249"),
                            Age = 0,
                            Gender = 0,
                            Height = 0.0,
                            Password = "AlexutPass",
                            UserName = "Alexut",
                            Weight = 0.0
                        },
                        new
                        {
                            Id = new Guid("6b1eea43-5597-45a6-bdea-e68c60564243"),
                            Age = 0,
                            Gender = 1,
                            Height = 0.0,
                            Password = "JohnutPass",
                            UserName = "Johnut",
                            Weight = 0.0
                        });
                });
#pragma warning restore 612, 618
        }
    }
}
