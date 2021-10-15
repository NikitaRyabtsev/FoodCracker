package by.htp.example.bean.dao;

import by.htp.example.bean.Food;

import java.util.List;

public interface FoodDao {

    List<Food> getAllFoodFromDB() throws DaoException;

}
