using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserApi.Contracts;

namespace UserApi.Controllers
{
    [ApiController]
    [Route("api/usernames")]
    public class UserNamesController : ControllerBase
    {
        private readonly IUserRepository _repository;

        public UserNamesController(IUserRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        [Route("{username}")]
        public IActionResult GetUserByUserName(string username)
        {
            var userFromRepo = _repository.GetUserByUserName(username);

            if (userFromRepo == null)
                return NotFound();

            return Ok(userFromRepo);
        }
    }
}
