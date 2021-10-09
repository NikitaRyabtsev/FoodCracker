package by.htp.example.bean.dao;

import by.htp.example.bean.user.User;

public interface UserDao {

	User authorization(String login, String password) throws DaoException;
	void registration(User user) throws DaoException;
	User deleteUserFromDB(User user) throws DaoException;
	void editProfileInDB(User user) throws DaoException;
	
}
