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

        [HttpGet("{userId}", Name = "GetUser")]
        public ActionResult GetUser(Guid userId)
        {
            var userFromRepo = _usersRepository.GetUser(userId);

            if (userFromRepo == null)
                return NotFound();

            return Ok(userFromRepo);

        }
    }
}