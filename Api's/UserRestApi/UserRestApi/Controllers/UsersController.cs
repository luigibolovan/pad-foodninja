using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;
using UserRestApi.Services;
using UserRestApi.Entities;

namespace UserRestApi.Controllers
{
    [ApiController]
    [Route("api/users")]
    public class UsersController : ControllerBase
    {
        private readonly IUserRepository _usersRepository;

        public UsersController(IUserRepository userReopsitory)
        {
            _usersRepository = userReopsitory ??
                throw new ArgumentNullException(nameof(userReopsitory));
        }

        [HttpOptions]
        public IActionResult GetUsersOptions()
        {
            Response.Headers.Add("Allow", "GET,POST,DELETE,HEAD,OPTIONS");
            return Ok();
        }

        [HttpGet("{userId}", Name = "GetUser")]
        public ActionResult GetUser(Guid userId)
        {
            var userFromRepo = _usersRepository.GetUser(userId);

            if (userFromRepo == null)
                return NotFound();

            return Ok(userFromRepo);

        }

        [HttpGet]
        public IActionResult GetAllUsers()
        {
            var usersFromRepo = _usersRepository.GetUsers();
            return Ok(usersFromRepo);
        }

        [HttpPost]
        public IActionResult CreateUser([FromBody]User user)
        {
            if (user == null)
                return BadRequest();

            _usersRepository.AddUser(user);
            _usersRepository.Save();

            return Ok();
        }

        [HttpDelete("{userId}")]
        public ActionResult DeleteUser(Guid userId)
        {
            var userFromRepo = _usersRepository.GetUser(userId);
            
            if (userFromRepo == null)
                return NotFound();

            _usersRepository.DeleteUser(userFromRepo);
            _usersRepository.Save();

            return NoContent();
        }
    }
}