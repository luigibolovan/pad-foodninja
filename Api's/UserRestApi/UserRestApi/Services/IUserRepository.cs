using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserRestApi.Entities;

namespace UserRestApi.Services
{
    public interface IUserRepository
    {
        IEnumerable<User> GetUsers();
        IEnumerable<User> GetUsers(IEnumerable<Guid> userIds);
        User GetUser(Guid userId);
        void Adduser(User user);
        void UpdateUser(User user);
        void Deleteuser(User user);

        UserInformation GetUserInformation(Guid userId);
        void AddUserInformation(Guid userId, UserInformation userInformation);
        void UpdateUserInformation(UserInformation userInformation);
        void DeleteUserInformation(UserInformation userInformation);

        bool UserExist(Guid userId);
        bool UserInformationExist(Guid userInformationId);
        bool Save();
    }
}
