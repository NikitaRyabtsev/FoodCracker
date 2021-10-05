package by.htp.example.service.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.bean.dao.UserDao;
import by.htp.example.bean.user.User;
import by.htp.example.service.ServiceException;
import by.htp.example.service.UserService;
import by.htp.example.validation.UserDataValidator;

public class UserServiceImpl implements UserService {

    private static final UserDataValidator validator = UserDataValidator.getInstance();

    @Override
    public User authorization(String login, String password) throws ServiceException {

        if (!validator.check(login, password)) {
            throw new ServiceException("[Info]Validation is not correct");
        }
        User user;

        UserDao userDao = DaoProvider.getInstance().getUserDao();
        user = userDao.authorization(login, password);

        return user;
    }


}
