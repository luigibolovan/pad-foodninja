using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace UserRestApi.Migrations
{
    public partial class Second : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "Id", "Email", "Password", "UserName" },
                values: new object[] { new Guid("b780cc58-533c-4286-b449-0e98b040c958"), "procepere@gmail.com", "Password", "BogdanPricepere" });

            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "Id", "Email", "Password", "UserName" },
                values: new object[] { new Guid("b780cc58-533c-4286-b449-0e98b040c859"), "procepere@gmail.com", "Password", "BogdanPricepere" });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("b780cc58-533c-4286-b449-0e98b040c859"));

            migrationBuilder.DeleteData(
                table: "Users",
                keyColumn: "Id",
                keyValue: new Guid("b780cc58-533c-4286-b449-0e98b040c958"));
        }
    }
}
