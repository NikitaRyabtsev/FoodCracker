package by.htp.example.dao;

import by.htp.example.dao.impl.SQLMealDao;
import by.htp.example.dao.impl.SQLUserDao;

public class DaoProvider {

	private final static DaoProvider instance = new DaoProvider();

	private UserDao userDao = new SQLUserDao();
	private MealDao mealDao = new SQLMealDao();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getAdminDao() {
		return userDao;
	}

	public MealDao getMealDao() {
		return mealDao;
	}
}
