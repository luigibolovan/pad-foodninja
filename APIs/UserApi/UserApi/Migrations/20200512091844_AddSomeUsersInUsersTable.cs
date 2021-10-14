using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace UserApi.Migrations
{
    public partial class AddSomeUsersInUsersTable : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "Id", "Age", "Gender", "Height", "Password", "UserName", "Weight" },
                values: new object[,]
                {
                    { new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"), 0, 0, 0.0, "MyPass", "BerceaSmen", 0.0 },
                    { new Guid("6b1eea43-5597-45a6-bdea-e68c60564248"), 0, 0, 0.0, "LuijiPass", "Luiji", 0.0 },
                    { new Guid("6b1eea43-5597-45a6-bdea-e68c60564249"), 0, 0, 0.0, "AlexutPass", "Alexut", 0.0 },
                    { new Guid("6b1eea43-5597-45a6-bdea-e68c60564243"), 0, 1, 0.0, "JohnutPass", "Johnut", 0.0 }
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564243"));

            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564247"));

            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564248"));

            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("6b1eea43-5597-45a6-bdea-e68c60564249"));
        }
    }
}
