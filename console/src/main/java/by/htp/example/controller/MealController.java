package by.htp.example.controller;

import by.htp.example.bean.Meal;
import by.htp.example.service.ServiceException;

import java.util.ArrayList;

public interface MealController {

	void viewMenu();

	void getMeals() throws ServiceException;

	Meal storeMeal() throws ServiceException;

	ArrayList<Meal> changeMealCharacteristics() throws ServiceException;
	
	void deleteMeal()throws ServiceException;
	
	void getMealById() throws ServiceException;
	
	void getMealByDate() throws ServiceException;
}
