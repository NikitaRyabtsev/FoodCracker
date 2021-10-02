package by.htp.example.bean.dao.impl;

import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.UserDao;

public class SQLUserDao implements UserDao , DaoQuery{

	@Override
	public User authorization(String login, String password) {
		User user = new User();
		
		user.setId(5);
		user.setName("Nikita");
		user.setRole("user");
		
		return user;
	}

}
