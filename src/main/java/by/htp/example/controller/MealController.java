package by.htp.example.controller;

import java.util.ArrayList;

import by.htp.example.bean.Meal;
import by.htp.example.service.ServiceException;

public interface MealController {

	public void viewMenu();
	
	void getMeals() throws ServiceException;

	Meal createMeal() throws ServiceException;

	ArrayList<Meal> changeMealCharacteristic() throws ServiceException;
	
	void deleteMeal()throws ServiceException;
	
	void getMealById() throws ServiceException;	
	
	void getMealByDate() throws ServiceException;
}
