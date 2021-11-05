package by.htp.example;

import by.htp.example.bean.Food;

import java.util.List;

public interface FoodService {
    List getAllFood() throws ServiceException;

    List<Food> getFoodByMeal(String keyMealId, String keyUserId) throws ServiceException;

    void addFoodInMeal(String keyMealId, String keyFoodId) throws ServiceException;
}
