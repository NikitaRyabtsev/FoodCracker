package by.htp.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.bean.Meal;

import javax.ejb.Local;

@Local
public interface MealService {

	List<Meal> getMeals(String keyUserId) throws ServiceException;

	Meal createMeal(String date,String time ,String id) throws ServiceException;

	Meal changeMealCharacteristic(String date, String time,String mealId )throws ServiceException;
	
	void deleteMeal(String id)throws ServiceException;
	
	Meal getMealById(String id) throws ServiceException;
	
	List<Meal> getMealByDate(String date) throws ServiceException;
}
