using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserApi.Entities;

namespace UserApi.Contracts
{
    public interface IUserRepository
    {
        User GetUser(Guid userId);
        void DeleteUser(User user);
        void UpdateUser(User user);
        User GetUserByUserName(string userName);
        void CreateUser(User user);
        IEnumerable<User> GetUsers();
        bool UserExist(Guid userId);
        bool Save();
    }
}
