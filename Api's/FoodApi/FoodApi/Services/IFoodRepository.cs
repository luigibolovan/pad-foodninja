using FoodApi.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FoodApi.Services
{
    public interface IFoodRepository
    {
        IEnumerable<Aliment> GetAliments();
        Aliment GetAliment(Guid alimentId);
        Aliment GetAlimetByName(string alimentName);
        void AddAliment(Aliment aliment);
        void DeleteAliment(Aliment aliment);
        void UpdateAliment(Aliment aliment);
        bool AlimetExist(Guid alimentId);
        bool Save();
    }
}
