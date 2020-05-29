using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace FoodApi.Migrations
{
    public partial class InitialMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Alimets",
                columns: table => new
                {
                    Id = table.Column<Guid>(nullable: false),
                    Name = table.Column<string>(maxLength: 100, nullable: false),
                    CaloriesPer1Gram = table.Column<int>(nullable: false),
                    ProteinPer1Gram = table.Column<int>(nullable: false),
                    FatPer1Gram = table.Column<int>(nullable: false),
                    CarbohidratesPer1Gram = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Alimets", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "Alimets",
                columns: new[] { "Id", "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "Name", "ProteinPer1Gram" },
                values: new object[] { new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"), 2, 3, 1, "Macaroane", 1 });

            migrationBuilder.InsertData(
                table: "Alimets",
                columns: new[] { "Id", "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "Name", "ProteinPer1Gram" },
                values: new object[] { new Guid("6b1eea43-5597-45a6-bdea-e68c60564274"), 2, 3, 1, "Lapte", 1 });

            migrationBuilder.InsertData(
                table: "Alimets",
                columns: new[] { "Id", "CaloriesPer1Gram", "CarbohidratesPer1Gram", "FatPer1Gram", "Name", "ProteinPer1Gram" },
                values: new object[] { new Guid("6b1eea43-5597-45a6-bdea-e68c60564435"), 2, 3, 1, "Oua", 1 });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Alimets");
        }
    }
}
