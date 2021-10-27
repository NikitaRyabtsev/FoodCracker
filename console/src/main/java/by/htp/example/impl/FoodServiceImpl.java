package by.htp.example.impl;


import by.htp.example.ServiceException;
import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.FoodService;

import java.util.List;

public class FoodServiceImpl implements FoodService  {

    DaoProvider provider = DaoProvider.getInstance();

    @Override
    public List getAllFood() throws ServiceException {
        List<Food> foods;
        try {
            foods = provider.getFoodDao().getAllFoodFromDB();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return foods;
    }

    @Override
    public List<Food> getFoodByMeal(String keyMealId, String keyUserId) throws ServiceException {
        List<Food> foods;
        try {
            foods = provider.getFoodDao().getFoodByMeal(Integer.parseInt(keyMealId), Integer.parseInt(keyUserId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return foods;
    }

    @Override
    public void addFoodInMeal(String keyMealId, String keyFoodId) throws ServiceException {

        try {
            provider.getFoodDao().addFoodInMealDB(Integer.parseInt(keyMealId), Integer.parseInt(keyFoodId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }
}
