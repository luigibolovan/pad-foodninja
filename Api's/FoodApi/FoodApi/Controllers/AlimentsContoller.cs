using FoodApi.Entities;
using FoodApi.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FoodApi.Controllers
{
    [ApiController]
    [Route("api/aliments")]
    public class AlimentsContoller : ControllerBase
    {
        private readonly IFoodRepository _foodRepository;

        public AlimentsContoller(IFoodRepository foodRepository)
        {
            _foodRepository = foodRepository ??
                throw new ArgumentNullException(nameof(foodRepository));
        }

        [HttpGet]
        public IActionResult GetAliments()
        {
            var alimentsFromRepo = _foodRepository.GetAliments();

            return Ok(alimentsFromRepo);
        }

        [HttpGet]
        [Route("{alimentId}")]
        public IActionResult GetAliment(Guid alimentId)
        {
            var alimentFromRepo = _foodRepository.GetAliment(alimentId);

            if (alimentFromRepo == null)
                return NotFound();

            return Ok(alimentFromRepo);
        }

        [HttpDelete]
        [Route("{alimentId}")]
        public IActionResult DeleteAliment(Guid alimentId)
        {
            var alimentToDelete = _foodRepository.GetAliment(alimentId);

            if (alimentToDelete == null)
                return NotFound();

            _foodRepository.DeleteAliment(alimentToDelete);
            _foodRepository.Save();

            return NoContent();
        }

        [HttpPost]
        public IActionResult CreateAliment([FromBody] Aliment aliment)
        {
            _foodRepository.AddAliment(aliment);
            _foodRepository.Save();

            return Ok();
        }
    }
}
