package by.htp.example.service;

import by.htp.example.bean.Food;
import by.htp.example.bean.Meal;

import java.util.List;

public interface FoodService {
    List getAllFood() throws ServiceException;

    List<Food> getFoodByMeal(String keyMealId,String keyUserId) throws ServiceException;
}
