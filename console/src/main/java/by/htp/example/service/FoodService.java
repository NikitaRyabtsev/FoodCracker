package by.htp.example.service;

import by.htp.example.bean.Food;
import by.htp.example.bean.Meal;

import java.util.List;

public interface FoodService {
    List getAllFood(int keyMealId , int keyUserId) throws ServiceException;

    Food createFood(Food food) throws ServiceException;
}
