package by.htp.example.service.impl;
import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.service.FoodService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;

import java.util.List;

public class FoodServiceImpl implements FoodService {

    DaoProvider provider = DaoProvider.getInstance();

    @Override
    public List getAllFood(int keyMealId , int keyUserId) throws ServiceException {
        List<Food> foods;
        try {
           foods = provider.getFoodDao().getAllFoodFromDB(keyMealId ,keyUserId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return foods;
    }

    @Override
    public Food createFood(Food food) throws ServiceException {
        try{
            provider.getFoodDao().createFoodInDB(food);
        }catch(DaoException e){
            throw new ServiceException(e);
        }
        return null;
    }
}
