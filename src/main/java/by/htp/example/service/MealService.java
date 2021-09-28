package by.htp.example.service;

import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealService {

	void getMeals() throws ServiceException;

	Meal createMeal();

	ArrayList<Meal> changeMealCharacteristic(ArrayList<Meal> meals);
	
	ArrayList<Meal> deleteMeal(ArrayList<Meal> meals);
	
	void getMealById() throws ServiceException;	
	
	void getMealByDate() throws ServiceException;
}
