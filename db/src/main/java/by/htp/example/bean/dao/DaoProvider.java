package by.htp.example.bean.dao;

import by.htp.example.bean.dao.impl.SQLFoodDao;
import by.htp.example.bean.dao.impl.SQLMealDao;
import by.htp.example.bean.dao.impl.SQLUserDao;

public class DaoProvider {

    private final static DaoProvider instance = new DaoProvider();

    private UserDao userDao = new SQLUserDao();
    private MealDao mealDao = new SQLMealDao();
    private FoodDao foodDao = new SQLFoodDao();

    private DaoProvider() {
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public FoodDao getFoodDao() {
        return foodDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public MealDao getMealDao() {
        return mealDao;
    }
}
