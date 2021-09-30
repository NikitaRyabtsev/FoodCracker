package by.htp.example.controller.impl;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.controller.MealController;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.util.Util;

public class MealControllerImpl implements MealController {

	ServiceProvider provider = ServiceProvider.getInstance();
	private Scanner scan;

	public void viewMenu() {
		int userChoose = 0;

		while (userChoose != 7) {
			try {
				showMenu();
				userChoose = Util.scanInt();

				switch (userChoose) {
				case 1:
					getMeals();
					break;
				case 2:
					createMeal();
					break;
				case 3:
					changeMealCharacteristic();
					break;
				case 4:
					deleteMeal();
					break;
				case 5:
					getMealById();
					break;
				case 6:
					getMealByDate();
					break;
				case 7:
					System.out.println("Goodbye");
					break;

				default:
					System.out.println(">>>[Info] Wrong choose");
				}

			} catch (InputMismatchException | IllegalArgumentException ex) {

			}catch(ServiceException e) {
				System.out.println("[Error] Something wrong in method viewMenu");
			}
		}

	}

	@Override
	public void getMeals() throws ServiceException {

		try {
			ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
			displayMeals(meals);
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println(">>>Wrong choose , try again");
		}

	}
//
	@Override
	public Meal createMeal() throws ServiceException {
		int id = 0;
		LocalDate date = null;
		LocalTime time = null;
		double weight = 0;
		double calories = 0;
		Meal meal;
		try {

			System.out.println("Input id of meal");
			id = Util.scanInt();
			date = Util.scanData();
			time = Util.scanTime();
			System.out.println("Input weight");
			weight = Util.scanDouble();
			System.out.println("Input calories");
			calories = Util.scanDouble();

		} catch (DateTimeException e) {
			System.out.println("[Info] Wrong Date");
		}
		meal = new Meal(id, date, time, weight, calories);
		System.out.println(meal.toString());
		provider.getServiceMeal().createMeal(meal);
		return meal;
	}

	@Override
	public ArrayList<Meal> changeMealCharacteristic() throws ServiceException {
		int userChoose;
		LocalDate date;
		LocalTime time;
		double weight;
		double calories;
		try {
			ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
			displayMeals(meals);
			System.out.println("Input number of Meal you want to change : ");
			userChoose = Util.scanInt();
			displayMeals(meals);
			Meal currentMeal = meals.get(userChoose - 1);
			System.out.println("Input number of characterisic you want to chang : ");
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
			provider.getServiceMeal().changeMealCharacteristic(currentMeal);
		} catch (InputMismatchException | IllegalArgumentException | DateTimeException ex) {
			System.out.println(">>> Wrong choose");
		} catch (ServiceException e) {
			System.out.println(">>>[Error] Something wrong in method changeMealCharacteristic()");
		}

		return null;

	}

	@Override

	public void deleteMeal() throws ServiceException {
		int userChoose;
		ArrayList<Meal> meals;
		try {
			meals = provider.getServiceMeal().getMeals();
			System.out.println("Input number of Meal u want to delete : ");
			if (meals != null && !meals.isEmpty()) {
				for (int i = 0; i < meals.size(); i++) {
					System.out.println("Meal  " + meals.get(i).getDate() + " " + meals.get(i).getTime());
				}
				userChoose = Util.scanInt();
				displayMeals(meals);
				provider.getServiceMeal().deleteMeal(meals.get(userChoose));
				System.out.println("-----Meal was deleted-----");

			}
		} catch (IllegalArgumentException e) {
			System.out.println(">>>[Info] Meal is not exist");
		} catch (ServiceException e1) {
			System.out.println(">>>[Error]Somethin wrong in method deleteMeal()]");
		}
	}

	@Override
	public void getMealById() throws ServiceException {
		int userChoose = 0;
		try {
			ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
			displayMeals(meals);
			System.out.println("Input meal number : ");
			userChoose = Util.scanInt();
			if (userChoose < 1 || userChoose > meals.size()) {
				throw new IllegalArgumentException();
			}

			System.out.println("------------------------------------------");

			System.out.println(meals.get(userChoose).toString());

			System.out.println("------------------------------------------");

		} catch (IllegalArgumentException e) {
			System.out.println(">>>[Info] Wrong choose , no such meal in the list");
		} catch (ServiceException ex) {
			System.out.println(">>>[Error] Error with method getMealById()");
		}

	}

	@Override
	public void getMealByDate() throws ServiceException {
		LocalDate userChoose;
		try {
			ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
			userChoose = Util.scanData();
			for (int i = 0; i < meals.size(); i++) {
				if (userChoose.equals(meals.get(i).getDate())) {
					System.out.println("------------------------------------------");
					System.out.println(meals.get(i).toString());
					System.out.println("------------------------------------------");
				}
			}
		} catch (DateTimeException ex) {
			System.out.println(">>>[Info]Wrong parameters");
		} catch (ServiceException e) {
			System.out.println("[Error] Something wrong with metho getMealByDate()");
		}
	}

	private void showMenu() {
		System.out.println("Choose your options : ");
		System.out.println("1. See all meals");
		System.out.println("2. Add meal");
		System.out.println("3. Change characteristic");
		System.out.println("4. Delete meal");
		System.out.println("5. Choose meal by Id");
		System.out.println("6. Choose meal by Date");
		System.out.println("7. Exit");
	}

	private void displayMeals(ArrayList<Meal> meals) {

		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				System.out.println(
						"#" + (i + 1) + " Meals Date: " + meals.get(i).getDate() + " Time: " + meals.get(i).getTime());
			}
		}
	}
}
