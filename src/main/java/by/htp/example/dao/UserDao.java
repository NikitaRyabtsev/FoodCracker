package by.htp.example.dao;

import by.htp.example.bean.user.User;

public interface UserDao {

	User authorization(String login, String password);
}
