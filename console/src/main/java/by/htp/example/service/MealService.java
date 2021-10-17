package by.htp.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.bean.Meal;

public interface MealService {

	ArrayList<Meal>getMeals(int keyUserId) throws ServiceException;

	Meal createMeal(Meal meal) throws ServiceException;

	Meal changeMealCharacteristic(Meal meal) throws ServiceException;
	
	Meal deleteMeal(Meal meal)throws ServiceException;
	
	Meal getMealById(int id) throws ServiceException;
	
	List<Meal> getMealByDate(LocalDate date) throws ServiceException;
}
