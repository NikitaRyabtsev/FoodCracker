package by.htp.example;

import by.htp.example.bean.Food;

import javax.ejb.Local;
import java.util.List;
    @Local
public interface FoodService {
    List getAllFood() throws ServiceException;

    List<Food> getFoodByMeal(String keyMealId, String keyUserId) throws ServiceException;

    List<Food> addFoodInMeal(String keyMealId,String keyFoodId) throws ServiceException;
}
