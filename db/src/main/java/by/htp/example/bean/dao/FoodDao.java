package by.htp.example.bean.dao;

import by.htp.example.bean.Food;
import by.htp.example.bean.Meal;

import java.util.List;

public interface FoodDao {

    List<Food> getAllFoodFromDB() throws DaoException;

    List<Food> getFoodByMeal(int keyMealId ,int keyUserId) throws DaoException;

    List<Food> addFoodInMealDB(int keyMealId,int keyFoodId) throws DaoException;
}
