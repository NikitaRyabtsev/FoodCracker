package by.htp.example.bean.dao;

import by.htp.example.bean.user.RegistrationInfo;
import by.htp.example.bean.user.User;

public interface UserDao {

	User authorization(String login, String password);
	void registration(RegistrationInfo info);
	
}
