package by.htp.example.service;

import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealService {

	ArrayList<by.htp.example.bean.Meal> getMeals() throws ServiceException;

	Meal createMeal(Meal meal) throws ServiceException;

	Meal changeMealCharacteristic(Meal meal) throws ServiceException;
	
	void deleteMeal(Meal meal)throws ServiceException;
	
	void getMealById() throws ServiceException;	
	
	void getMealByDate() throws ServiceException;
}
