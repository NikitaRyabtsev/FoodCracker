package by.htp.example.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;

public class MealServiceImpl implements MealService {

    private DaoProvider provider = DaoProvider.getInstance();

    public ArrayList<Meal> getMeals(int keyUserId) throws ServiceException {
        ArrayList<Meal> meals;
        try {
            meals = provider.getMealDao().getMealsFromDB(keyUserId);

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return meals;
    }

    @Override
    public Meal createMeal(Meal meal) throws ServiceException {

        try {
            return provider.getMealDao().createMealInDB(meal);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Meal changeMealCharacteristic(Meal meal) throws ServiceException {

        try {
            provider.getMealDao().changeMealCharacteristicInDB(meal);
            return meal;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public Meal deleteMeal(Meal meal) throws ServiceException {

        try {
            return provider.getMealDao().deleteMealFromDB(meal);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Meal getMealById(int id) throws ServiceException {

        try {
            return provider.getMealDao().getMealByIdFromDB(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Meal> getMealByDate(LocalDate date) throws ServiceException {
        try {
            return provider.getMealDao().getMealByDateFromDB(date);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }


    }
}
