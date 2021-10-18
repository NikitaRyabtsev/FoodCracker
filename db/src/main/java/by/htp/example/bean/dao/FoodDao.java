package by.htp.example.bean.dao;

import by.htp.example.bean.Food;
import by.htp.example.bean.Meal;

import java.util.List;

public interface FoodDao {

    List<Food> getAllFoodFromDB(int keyMealId , int keyUserId) throws DaoException;

    Food createFoodInDB(Food food) throws DaoException;
}
