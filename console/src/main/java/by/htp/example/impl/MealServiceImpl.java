package by.htp.example.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.MealServiceRemote;
import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.MealService;
import by.htp.example.ServiceException;

import javax.ejb.Stateless;

@Stateless
public class MealServiceImpl implements  MealService,MealServiceRemote{

    private DaoProvider provider = DaoProvider.getInstance();

    public List<Meal> getMeals(String keyUserId) throws ServiceException {

        List<Meal> meals;
        try {
            meals = provider.getMealDao().getMealsFromDB(Integer.parseInt(keyUserId));

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return meals;
    }

    @Override
    public Meal createMeal(String date,String time ,String id) throws ServiceException {
            Meal meal;
        try {
           meal = provider.getMealDao().createMealInDB(LocalDate.parse(date),
                    LocalTime.parse(time), Integer.parseInt(id));
           return meal;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Meal changeMealCharacteristic(String date ,
                                         String time,String mealId) throws ServiceException {
        Meal meal;
        try {
            meal = provider.getMealDao().changeMealCharacteristicInDB(LocalDate.parse(date)
                        ,LocalTime.parse(time) , Integer.parseInt(mealId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return meal;
    }

    @Override
    public void deleteMeal(String id) throws ServiceException {

        try {
          provider.getMealDao().deleteMealFromDB(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Meal getMealById(String id) throws ServiceException {

        try {
            return provider.getMealDao().getMealByIdFromDB(Integer.parseInt(id));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Meal> getMealByDate(String date) throws ServiceException {
        try {
            return provider.getMealDao().getMealByDateFromDB(LocalDate.parse(date));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }


    }
}
