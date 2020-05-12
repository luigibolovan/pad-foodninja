using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace FoodApi.Migrations
{
    public partial class Nutrientsvaluesmodified : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CaloriesPer1Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "CarbohidratesPer1Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "FatPer1Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "ProteinPer1Gram",
                table: "Alimets");

            migrationBuilder.AddColumn<int>(
                name: "CaloriesPer100Gram",
                table: "Alimets",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "CarbohidratesPer100Gram",
                table: "Alimets",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "FatPer100Gram",
                table: "Alimets",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "ProteinPer100Gram",
                table: "Alimets",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"),
                columns: new[] { "CaloriesPer100Gram", "CarbohidratesPer100Gram", "FatPer100Gram", "ProteinPer100Gram" },
                values: new object[] { 2, 3, 1, 1 });

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564274"),
                columns: new[] { "CaloriesPer100Gram", "CarbohidratesPer100Gram", "FatPer100Gram", "ProteinPer100Gram" },
                values: new object[] { 2, 3, 1, 1 });

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564435"),
                columns: new[] { "CaloriesPer100Gram", "CarbohidratesPer100Gram", "FatPer100Gram", "ProteinPer100Gram" },
                values: new object[] { 2, 3, 1, 1 });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CaloriesPer100Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "CarbohidratesPer100Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "FatPer100Gram",
                table: "Alimets");

            migrationBuilder.DropColumn(
                name: "ProteinPer100Gram",
                table: "Alimets");

            migrationBuilder.AddColumn<int>(
                name: "CaloriesPer1Gram",
                table: "Alimets",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "CarbohidratesPer1Gram",
                table: "Alimets",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "FatPer1Gram",
                table: "Alimets",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "ProteinPer1Gram",
                table: "Alimets",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"),
                columns: new[] { "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "ProteinPer1Gram" },
                values: new object[] { 2, 3, 1, 1 });

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564274"),
                columns: new[] { "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "ProteinPer1Gram" },
                values: new object[] { 2, 3, 1, 1 });

            migrationBuilder.UpdateData(
                table: "Alimets",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564435"),
                columns: new[] { "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "ProteinPer1Gram" },
                values: new object[] { 2, 3, 1, 1 });
        }
    }
}
