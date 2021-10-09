package by.htp.example.service;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;

public interface UserService {

	User authorization(String login , String password) throws ServiceException, DaoException;
	void registration(User user) throws ServiceException;
}
