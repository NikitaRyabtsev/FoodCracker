package by.htp.example.bean.dao;

import by.htp.example.bean.dao.impl.SQLUserDao;
import by.htp.example.bean.dao.impl.SQLMealDao;

public class DaoProvider {

	private final static DaoProvider instance = new DaoProvider();

	private UserDao userDao = new SQLUserDao();
	private MealDao mealDao = new SQLMealDao();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public MealDao getMealDao() {
		return mealDao;
	}
}
