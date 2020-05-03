using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ModelBinding.Binders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserRestApi.Entities;
using UserRestApi.Helpers;
using UserRestApi.Services;

namespace UserRestApi.Controllers
{
    [ApiController]
    [Route("api/usercollections")]
    public class UserCollectionsController : ControllerBase
    {
        private readonly IUserRepository _userRepository;

        public UserCollectionsController(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        [HttpGet("({ids})", Name = "GetUserCollection")]
        public IActionResult GetUserCollection([FromRoute]
            [ModelBinder(BinderType = typeof(ArrayModelBinder))]IEnumerable<Guid> ids)
        {
            if (ids == null)
                return NotFound();

            var userEntities =_userRepository.GetUsers(ids);

            if (ids.Count() != userEntities.Count())
                return NotFound();

            return Ok(userEntities);
        }

       
        [HttpPost]
        public IActionResult CreateUserCollection([FromBody]IEnumerable<User> userCollection)
        {
            if (userCollection == null)
                return BadRequest();
           
            foreach(var user in userCollection)
            {
                _userRepository.AddUser(user);
            }

            _userRepository.Save();

            return Ok();
        }
    }
}
