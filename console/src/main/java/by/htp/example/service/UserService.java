package by.htp.example.service;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;

public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;

    User editProfile(User user) throws ServiceException;

    User deleteMeal(User user) throws ServiceException;
}
