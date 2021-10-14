using FoodApi.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FoodApi.Controllers
{
    [ApiController]
    [Route("api/alimentbyname")]
    public class AlimentByNameController : ControllerBase
    {
        private readonly IFoodRepository _foodRepository;

        public AlimentByNameController(IFoodRepository foodRepository)
        {
            _foodRepository = foodRepository ??
                throw new ArgumentNullException(nameof(foodRepository));
        }

        [HttpGet]
        [Route("{alimentName}")]
        public IActionResult GetAlimentByName(string alimentName)
        {
            var alimentFromRepo = _foodRepository.GetAlimetByName(alimentName);

            if (alimentFromRepo == null)
                return NotFound();

            return Ok(alimentFromRepo);
        }
    }
}
