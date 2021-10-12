package by.htp.example.bean.dao;

import by.htp.example.bean.user.User;

import java.util.List;

public interface UserDao {

    User authorization(String login, String password) throws DaoException;

    void registration(User user) throws DaoException;

    User deleteUserFromDB(User user) throws DaoException;

    User blockUserInDB(User user) throws DaoException;

    List<User> getAllUsersFromDB() throws DaoException;

	User getEditAdminAccessInfo(int id) throws DaoException;

	User getEditUserAccessInfo(int id) throws DaoException;

}
