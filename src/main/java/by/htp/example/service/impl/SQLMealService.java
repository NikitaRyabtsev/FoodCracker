package by.htp.example.service.impl;

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

	private DaoProvider provider = DaoProvider.getInstance();

	public ArrayList<Meal> getMeals() throws ServiceException {
		ArrayList<Meal> meals;
		try {
			meals = provider.getMealDao().getMealsFromDB();
			
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return meals;
	}

	@Override
	public Meal createMeal() throws ServiceException {

		int id = 0;
		LocalDate date = null;
		LocalTime time = null;
		double weight = 0;
		double calories = 0;
		System.out.println("Input id of meal");
		id = Util.scanInt();
		date = Util.scanData();
		time = Util.scanTime();
		System.out.println("Input weight");
		weight = Util.scanDouble();
		System.out.println("Input calories");
		calories = Util.scanDouble();

		Meal meal = new Meal(id, date, time, weight, calories);
		System.out.println(meal.toString());
		try {

			provider.getMealDao().createMealInDB(meal);

		} catch (DaoException e) {
			throw new ServiceException(e);

		}
		return meal;

	}

	@Override
	public ArrayList<Meal> changeMealCharacteristic() throws ServiceException {
		scan = new Scanner(System.in);
		int userChoose;
		try {
			ArrayList<Meal> meals;
			meals = provider.getMealDao().getMealsFromDB();
			LocalDate date = null;
			LocalTime time = null;
			double weight = 0;
			double calories = 0;

			if (meals != null && !meals.isEmpty()) {
				System.out.println("Input number of meal you want to edit");
				try {
					userChoose = scan.nextInt();

					if (userChoose < 1 || userChoose > meals.size()) {
						throw new IllegalArgumentException();
					}

					Meal currentMeal = meals.get(userChoose - 1);

					System.out.println("#1 Change date : ");
					System.out.println("#2 Change time : ");
					System.out.println("#3 Change weight : ");
					System.out.println("#4 Change calories : ");
					System.out.println("#5 Previous menu : ");

					userChoose = Util.scanInt();

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
					provider.getMealDao().changeMealCharacteristicInDB(currentMeal);
				} catch (InputMismatchException | IllegalArgumentException ex) {
					System.out.println(">>> Wrong choose , no such Meal in note");
				}
			}
			return meals;

		} catch (DaoException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void deleteMeal() throws ServiceException {
		int userChoose;
		ArrayList<Meal> meals = null;
		try {
			meals = provider.getMealDao().getMealsFromDB();
			scan = new Scanner(System.in);
			System.out.println("Input number of Meal u want to delete : ");
			if (meals != null && !meals.isEmpty()) {
				for (int i = 0; i < meals.size(); i++) {
					System.out.println("Meal  " + meals.get(i));
				}
			}
			userChoose = Util.scanInt();
			try {
				if (meals != null && !meals.isEmpty()) {
					userChoose--;
					if (userChoose < 1 || userChoose > meals.size()) {
						throw new IllegalArgumentException();
					}

					provider.getMealDao().deleteMealFromDB(meals.get(userChoose));
					System.out.println("-----Meal was deleted-----");

				}
			} catch (IllegalArgumentException e) {
				System.out.println(">>>Wrong choose");
			}
		} catch (DaoException e1) {
			throw new ServiceException(e1);

		}

	}

	@Override
	public void getMealById() throws ServiceException {

		try {
			//ArrayList<Meal> meals 
			provider.getMealDao().getMealsFromDB();
			System.out.println("Choose meal Id : ");
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void getMealByDate() throws ServiceException {
	
			try {
				//ArrayList<Meal> meals  
				provider.getMealDao().getMealsFromDB();
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
		
	}
}
