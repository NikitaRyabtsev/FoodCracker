package by.htp.example.controller;

import by.htp.example.bean.Meal;
import com.google.protobuf.ServiceException;

import java.util.ArrayList;

public interface MealController {

	void viewMenu();
	//
	void getMeals() throws ServiceException, by.htp.example.service.ServiceException;

	Meal createMeal() throws ServiceException, by.htp.example.service.ServiceException;

	ArrayList<Meal> changeMealCharacteristic() throws ServiceException, by.htp.example.service.ServiceException;
	
	void deleteMeal()throws ServiceException, by.htp.example.service.ServiceException;
	
	void getMealById() throws ServiceException, by.htp.example.service.ServiceException;
	
	void getMealByDate() throws ServiceException, by.htp.example.service.ServiceException;
}
