package by.htp.example.service;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;

    User getAdminAccessInfo(int id) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void blockUser(User user) throws ServiceException;

    User getUserAccessInfo(int id) throws ServiceException;

    User deleteUser(User user) throws ServiceException;

    User addUserWeight(String id ,String weight, String date) throws ServiceException;
}
