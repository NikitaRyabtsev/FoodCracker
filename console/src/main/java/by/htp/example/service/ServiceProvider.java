package by.htp.example.service;

import by.htp.example.service.impl.SQLMealService;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	
	ServiceProvider(){}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	private final MealService mealService = new SQLMealService();
	
	public MealService getServiceMeal() {
		return mealService;
	}
	
}

