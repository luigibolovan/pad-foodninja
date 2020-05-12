using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserApi.Contracts;
using UserApi.Controllers;
using UserApi.Entities;

namespace UserApi.Services
{
    public class UserRepository : IUserRepository
    {
        private readonly UserContext _contex;

        public UserRepository(UserContext context)
        {
            _contex = context;
        }

        public void CreateUser(User user)
        {
            if (user == null)
                throw new ArgumentNullException(nameof(user));

            _contex.Users.Add(user);
        }

        public void DeleteUser(User user)
        {
            if (user == null)
                throw new ArgumentNullException(nameof(user));

            _contex.Users.Remove(user);
        }

        public User GetUser(Guid userId)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));

            return _contex.Users.Where(usr => usr.Id == userId).FirstOrDefault();
        }

        public IEnumerable<User> GetUsers()
        {
            return _contex.Users.ToList();
        }

        public bool Save()
        {
            return (_contex.SaveChanges() >= 0);
        }

        public void UpdateUser(User user)
        {
            if (user == null)
                throw new ArgumentNullException(nameof(user));

            _contex.Users.Update(user);
        }

        public bool UserExist(Guid userId)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));

            return _contex.Users.Any(usr => usr.Id == userId);
        }
    }
}
