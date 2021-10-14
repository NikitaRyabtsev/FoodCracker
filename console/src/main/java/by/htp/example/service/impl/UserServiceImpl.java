package by.htp.example.service.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.bean.dao.UserDao;
import by.htp.example.bean.user.User;
import by.htp.example.service.ServiceException;
import by.htp.example.service.UserService;
import by.htp.example.validation.UserDataValidator;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDataValidator validator = UserDataValidator.getInstance();
    private DaoProvider provider = DaoProvider.getInstance();
    @Override
    public User authorization(String login, String password) throws ServiceException{

        if (!validator.check(login, password)) {
            throw new ServiceException("[Info]Validation is not correct");
        }
        User user;
        try{
            UserDao userDao = DaoProvider.getInstance().getUserDao();
            user = userDao.authorization(login, password);
        }catch(DaoException e){
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void registration(User user) throws ServiceException {
        UserDao userDao = DaoProvider.getInstance().getUserDao();
       try {
           userDao.registration(user);
       }catch(DaoException e){
           throw new ServiceException(e);
       }
    }

    @Override
    public User getAdminAccessInfo(int id) throws ServiceException {
        try{
            return provider.getUserDao().getEditAdminAccessInfo(id);
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsers() throws ServiceException {
        try{
            return provider.getUserDao().getAllUsersFromDB();
        }catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    @Override
    public User blockUser(User user) throws ServiceException {
        try{
            return provider.getUserDao().blockUserInDB(user);
        }catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    @Override
    public User getUserAccessInfo(String id) throws ServiceException {
        try{
            return provider.getUserDao().getEditUserAccessInfo(Integer.parseInt(id));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public User deleteUser(User user) throws ServiceException {
        UserDao userDao = DaoProvider.getInstance().getUserDao();
        try {
            userDao.deleteUserFromDB(user);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
