using FoodApi.DbContexts;
using FoodApi.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Threading.Tasks;

namespace FoodApi.Services
{
    public class FoodRepository : IFoodRepository
    {
        private readonly FoodContext _foodContext;

        public FoodRepository(FoodContext foodContext)
        {
            _foodContext = foodContext ??
                throw new ArgumentNullException(nameof(foodContext));
        }

        public void AddAliment(Aliment aliment)
        {
            if (aliment == null)
                throw new ArgumentNullException(nameof(aliment));

            _foodContext.Add(aliment);
        }

        public bool AlimetExist(Guid alimentId)
        {
            if (alimentId == Guid.Empty)
                throw new ArgumentNullException(nameof(alimentId));

            return _foodContext.Alimets.Any(alm => alm.Id == alimentId);
        }

        public void DeleteAliment(Aliment aliment)
        {
            if (aliment == null)
                throw new ArgumentNullException(nameof(aliment));

            _foodContext.Alimets.Remove(aliment);
        }

        public Aliment GetAliment(Guid alimentId)
        {
            if (alimentId == Guid.Empty)
                throw new ArgumentNullException(nameof(alimentId));

            return _foodContext.Alimets.Where(alm => alm.Id == alimentId).FirstOrDefault();
        }

        public IEnumerable<Aliment> GetAliments()
        {
            return _foodContext.Alimets.OrderBy(alm => alm.Name).ToList();
        }

        public Aliment GetAlimetByName(string alimentName)
        {
            if (string.IsNullOrWhiteSpace(alimentName))
                throw new ArgumentNullException(nameof(alimentName));

            return _foodContext.Alimets
                .Where(alm => alm.Name == alimentName)
                .FirstOrDefault();
        }

        public bool Save()
        {
            return (_foodContext.SaveChanges() >= 0);
        }

        public void UpdateAliment(Aliment aliment)
        {
            //Not implemented
        }
    }
}
