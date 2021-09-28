package by.htp.example.service.impl;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.dao.DaoException;
import by.htp.example.dao.DaoProvider;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.util.Util;



public class SQLMealService implements MealService {

	private Scanner scan;

	private DaoProvider instance = DaoProvider.getInstance();
	public void getMeals() throws ServiceException{

		
		scan = new Scanner(System.in);
		int userChoose;
		try {
			while (true) {
				
				try{
					ArrayList<Meal> meals = instance.getMealDao().getMealsFromDB();
			
				showMenu(meals);
				userChoose = scan.nextInt();
				if (userChoose < 1 || userChoose > meals.size() + 2) {
					throw new IllegalArgumentException();
				}
				if (userChoose == meals.size() + 1) {
					break;
				}

				System.out.println(instance.getMealDao().getMealsFromDB().get(userChoose - 1).toString());
				System.out.println("--------------------------");
				}catch(DaoException e) {
					throw new ServiceException(e);
				}
			}
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.out.println(">>> Wrong choose, try again");
		}
	}

	private void showMenu(ArrayList<Meal> meals)throws ServiceException{
		System.out.println("For more information choose a meal:");
		
		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				
				try {
					System.out.println(instance.getMealDao().getMealsFromDB().get(i));
				} catch (DaoException e) {
					throw new ServiceException(e);
				}
			}
			System.out.println((meals.size() + 1) + ". Previous menu");
			}
	
	}
	@Override
	public Meal createMeal() {
		scan = new Scanner(System.in);
		int id =0;
		LocalDate date = null;
		LocalTime time = null;
		double weight = 0;
		double calories = 0;
		System.out.println("Input id of meal");
		id = scan.nextInt();
		date = Util.scanData();
		time = Util.scanTime();
		System.out.println("Input weight");
		weight = Util.scanDouble();
		System.out.println("Input calories");
		calories = Util.scanDouble();

		Meal meal = new Meal(id, date, time, weight, calories);
		System.out.println(meal.toString());

		return meal;

	}

	@Override
	public ArrayList<Meal> changeMealCharacteristic(ArrayList<Meal> meals) {
		scan = new Scanner(System.in);

		int userChoose;

		LocalDate date = null;
		LocalTime time = null;
		double weight = 0;
		double calories = 0;
		if (meals != null && !meals.isEmpty()) {
			System.out.println("Input number of meal you want to edit");
			try {
				userChoose = scan.nextInt();
				if (userChoose < 1 || userChoose > meals.size() + 1) {
					throw new IllegalArgumentException();
				}
				Meal currentMeal = meals.get(userChoose - 1);
				System.out.println("#1 Change date : ");
				System.out.println("#2 Change time : ");
				System.out.println("#3 Change weight : ");
				System.out.println("#4 Change calories : ");
				System.out.println("#5 Previous menu : ");
				scan = new Scanner(System.in);
				if (userChoose < 1 || userChoose > 5) {
					throw new IllegalArgumentException();
				}
				
				switch (userChoose) {
				case 1:
					System.out.println("Input date: ");
					date = Util.scanData();
					currentMeal.setDate(date);
					break;
				case 2:
					System.out.println("Input time: ");
					time = Util.scanTime();
					currentMeal.setTime(time);
					break;
				case 3:
					System.out.println("Input weight: ");
					weight = scan.nextDouble();
					currentMeal.setWeight(weight);
					break;
				case 4:
					System.out.println("Input calories");
					calories = scan.nextDouble();
					currentMeal.setCalories(calories);
				case 5:
				
					break;
				default:
					System.out.println(">>>Wrong choose");

				}

			} catch (InputMismatchException | IllegalArgumentException ex) {
				System.out.println(">>> Wrong choose");

			}
		}
		return meals;
	}

	@Override
	public ArrayList<Meal> deleteMeal(ArrayList<Meal> meals) {
			
		int userChoose;
		scan = new Scanner(System.in);
		System.out.println("Input number of Meal u want to delete : ");
		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				System.out.println((meals.get(i).getId()) + ". " + "Meal  " + meals.get(i));;
			}
		}
		userChoose = scan.nextInt();	
		if (meals != null && !meals.isEmpty()) {
					userChoose--;
				try {					
					System.out.println("Meal was deleted " + meals.remove(userChoose));					
			}catch(IllegalArgumentException e) {				
				System.out.println(">>>Wrong choose");
			}
		}else {
			System.out.println("No meals");
		}	
		return meals;
	}

	@Override
	public void getMealById() throws ServiceException {
		int userChoose = 0;

		try {
			ArrayList<Meal> meals = instance.getMealDao().getMealsFromDB();
			if(meals !=null && !meals.isEmpty()) {
				for(int i = 0 ; i < meals.size();i++ )					
				
					System.out.println(meals.get(i));							
			}
				System.out.println("Choose meal Id : ");
				userChoose = Util.scanInt();
				
				if (userChoose < 1 || userChoose > meals.size()) {					
						throw new IllegalArgumentException();	
				}
				System.out.println("------------------------------------------");
				System.out.println(meals.get(userChoose - 1).toString());
				System.out.println("------------------------------------------");					
		}catch(DaoException e) {				
			throw new ServiceException(e);
		}		
	}

	@Override
	public void getMealByDate() throws ServiceException {
		LocalDate userChoose;
	try {	
		try {
			ArrayList<Meal> meals = instance.getMealDao().getMealsFromDB();
			userChoose = Util.scanData();
			if(meals !=null && !meals.isEmpty()) {
				for(int i = 0 ; i < meals.size();i++ )		{			
				if(userChoose.equals(meals.get(i).getDate())) {
					System.out.println("------------------------------------------");
					System.out.println(meals.get(i).toString());
					System.out.println("------------------------------------------");		
					}else {
						System.out.println("No such meal");
					}
				}					
			}
					
		}catch(DaoException e) {				
			
			throw new ServiceException(e);
		}		
	}catch(DateTimeException ex) {
		System.out.println(">>>>Wrong date");
	}
	}
}
