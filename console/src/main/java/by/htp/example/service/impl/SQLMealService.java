package by.htp.example.service.impl;

import java.util.ArrayList;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;

public class SQLMealService implements MealService {

	private DaoProvider provider = DaoProvider.getInstance();

	public ArrayList<Meal> getMeals() throws ServiceException {
		ArrayList<Meal> meals;
		try {
			meals = provider.getMealDao().getMealsFromDB();

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
			throw new ServiceException();
		}

	}

	@Override
	public void deleteMeal(Meal meal) throws ServiceException {

		try {
			provider.getMealDao().deleteMealFromDB(meal);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void getMealById() throws ServiceException {

		try {
			provider.getMealDao().getMealsFromDB();
			System.out.println("Choose meal Id : ");
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void getMealByDate() throws ServiceException {
		try {
			provider.getMealDao().getMealsFromDB();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}
}
