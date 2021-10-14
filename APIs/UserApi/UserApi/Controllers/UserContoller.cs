using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserApi.Contracts;
using UserApi.Entities;

namespace UserApi.Controllers
{
    [ApiController]
    [Route("api/users")]
    public class UserContoller : ControllerBase
    {
        private readonly IUserRepository _repository;

        public UserContoller(IUserRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public IActionResult GetUsers()
        {
            var usersFromRepo = _repository.GetUsers();

            return Ok(usersFromRepo);
        }

        [HttpGet]
        [Route("{userId}", Name = "GetUser")]
        public IActionResult GetUser(Guid userId)
        {
            var userFromRepo = _repository.GetUser(userId);

            if (userFromRepo == null)
                return NotFound();

            return Ok(userFromRepo);
        }

        [HttpDelete]
        [Route("{userId}")]
        public IActionResult DeleteUser(Guid userId)
        {
            var userFromRepo = _repository.GetUser(userId);

            if (userFromRepo == null)
                return NotFound();

            _repository.DeleteUser(userFromRepo);
            _repository.Save();

            return NoContent();
        }

        [HttpPost]
        public ActionResult<User> CreateUser([FromBody] User user)
        {
            _repository.CreateUser(user);
            _repository.Save();

            return CreatedAtRoute("GetUser", new { userId = user.Id }, user);
        }
    }
}
