package by.htp.example.service;

import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealService {

	ArrayList<Meal> getMeals() throws ServiceException;

	Meal createMeal() throws ServiceException;

	ArrayList<Meal> changeMealCharacteristic() throws ServiceException;
	
	void deleteMeal()throws ServiceException;
	
	void getMealById() throws ServiceException;	
	
	void getMealByDate() throws ServiceException;
}
