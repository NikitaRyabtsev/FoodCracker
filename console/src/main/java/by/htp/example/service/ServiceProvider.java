package by.htp.example.service;

import by.htp.example.service.impl.MealServiceImpl;
import by.htp.example.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	
	ServiceProvider(){}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	private final MealService mealService = new MealServiceImpl();
	
	private final UserService userService = new UserServiceImpl();
	
	public MealService getServiceMeal() {
		return mealService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
}
