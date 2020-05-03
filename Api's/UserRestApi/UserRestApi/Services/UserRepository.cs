using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UserRestApi.DbContexts;
using UserRestApi.Entities;

namespace UserRestApi.Services
{
    public class UserRepository : IUserRepository
    {
        private readonly UserContext _userContext;

        public UserRepository(UserContext userContext)
        {
            _userContext = userContext ??
                throw new ArgumentNullException(nameof(userContext));
        }

        public void Adduser(User user)
        {
            if (user == null)
                throw new ArgumentNullException(nameof(user));

            _userContext.Users.Add(user);
        }

        public void AddUserInformation(Guid userId, UserInformation userInformation)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));
            if (userInformation == null)
                throw new ArgumentNullException(nameof(userInformation));

            userInformation.UserId = userId;
            _userContext.UsersInformation.Add(userInformation);
        }

        public void Deleteuser(User user)
        {
            if (user == null)
                throw new ArgumentNullException(nameof(user));

            _userContext.Users.Remove(user);
        }

        public void DeleteUserInformation(UserInformation userInformation)
        {
            if (userInformation == null)
                throw new ArgumentNullException(nameof(userInformation));

            _userContext.UsersInformation.Remove(userInformation);
        }

        public User GetUser(Guid userId)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));

            return _userContext.Users.Where(usr => usr.Id == userId)
                .FirstOrDefault();
        }

        public UserInformation GetUserInformation(Guid userId)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));

            return _userContext.UsersInformation.Where(usrInfo =>
                usrInfo.UserId == userId).FirstOrDefault();
        }

        public IEnumerable<User> GetUsers()
        {
            return _userContext.Users.ToList();
        }

        public IEnumerable<User> GetUsers(IEnumerable<Guid> userIds)
        {
            if (userIds == null)
                throw new ArgumentNullException(nameof(userIds));

            return _userContext.Users.Where(usr => userIds.Contains(usr.Id))
                .OrderBy(usr => usr.UserName)
                .ToList();
        }

        public bool Save()
        {
            return (_userContext.SaveChanges() >= 0);
        }

        public void UpdateUser(User user)
        {
            // Not Implemented
        }

        public void UpdateUserInformation(UserInformation userInformation)
        {
            // Not Implemented
        }

        public bool UserExist(Guid userId)
        {
            if (userId == Guid.Empty)
                throw new ArgumentNullException(nameof(userId));

            return _userContext.Users.Any(usr => usr.Id == userId);
        }

        public bool UserInformationExist(Guid userInformationId)
        {
            if (userInformationId == Guid.Empty)
                throw new ArgumentNullException(nameof(userInformationId));

            return _userContext.UsersInformation.Any(usrInfo => usrInfo.Id == userInformationId);
        }
    }
}
