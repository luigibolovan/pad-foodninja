using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace FoodApi.Entities
{
    public class Aliment
    {
        public Guid Id { get; set; }

        [Required(ErrorMessage = "Aliment name must be provided")]
        [MaxLength(100, ErrorMessage = "Aliment name must be up to 100 characters")]
        public string Name { get; set; }
        [Required]
        [Range(0, 100)]
        public int CaloriesPer1Gram { get; set; }
        [Required]
        [Range(0, 100)]
        public int ProteinPer1Gram { get; set; }
        [Required]
        [Range(0, 100)]
        public int FatPer1Gram { get; set; }
        [Required]
        [Range(0, 100)]
        public int CarbohidratesPer1Gram { get; set; }
    }
}
