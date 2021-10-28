package by.htp.example.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.bean.dao.UserDao;
import by.htp.example.bean.user.User;
import by.htp.example.ServiceException;
import by.htp.example.UserService;
import by.htp.example.bean.user.UserWeightInfo;
import by.htp.example.validation.UserDataValidator;

import java.time.LocalDate;
import java.util.List;


public class UserServiceImpl implements UserService{

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
    public User getAdminAccessInfo(String id) throws ServiceException {
        try{
            return provider.getUserDao().getEditAdminProfileInfo(Integer.parseInt(id));
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
    public void blockUser(User user) throws ServiceException {
        try{
            provider.getUserDao().blockUserInDB(user);
        }catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    @Override
    public User getUserAccessInfo(String id) throws ServiceException {
        try{
            return provider.getUserDao().getEditUserAccessInfo(
                    Integer.parseInt(id));
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

    @Override
    public void addUserWeight(String id ,String weight, String date) throws ServiceException {
        UserDao userDao = DaoProvider.getInstance().getUserDao();
        User user;
        try{
            userDao.addUserWeightInDB(Integer.parseInt(id),Double.parseDouble(weight)
                    ,LocalDate.parse(date));
        }catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    @Override
    public User EditProfileInDB(String login , String password , String name, String secondName
            , String email, String sex , String dateOfBirth , String id) throws ServiceException {
        try{

            return provider.getUserDao().EditProfileInDB(login,password,name,secondName
                        ,email,sex,LocalDate.parse(dateOfBirth),Integer.parseInt(id));

        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<UserWeightInfo> getWeightFromDB(String id) throws ServiceException {
        try{
            return provider.getUserDao().getWeightFromDB(Integer.parseInt(id));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }


}
