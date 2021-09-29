package by.htp.example.controller.impl;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;

import by.htp.example.controller.MealController;
import by.htp.example.dao.DaoException;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.util.Util;

public class MealControllerImpl implements MealController {

	ServiceProvider provider = ServiceProvider.getInstance();
	private Scanner scan;

	public void viewMenu() {
		ServiceProvider instance = ServiceProvider.getInstance();
		Scanner scan = new Scanner(System.in);
		int userChoose = 0;

		while (userChoose != 7) {
			try {
				showMenu();
				userChoose = scan.nextInt();

				switch (userChoose) {
				case 1:
					getMeals();
					break;
				case 2:
					instance.getServiceMeal().createMeal();
					break;
				case 3:
					instance.getServiceMeal().changeMealCharacteristic();
					break;
				case 4:
					instance.getServiceMeal().deleteMeal();
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
					System.out.println(">>> Wrong choose");
				}

			} catch (InputMismatchException | IllegalArgumentException | ServiceException ex) {

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

	@Override
	public Meal createMeal() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Meal> changeMealCharacteristic() throws ServiceException {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMeal() throws ServiceException {
		// TODO Auto-generated method stub

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
			// checkMeals(meals);
			userChoose = Util.scanData();
			for (int i = 0; i < meals.size(); i++) {
				if (userChoose.equals(meals.get(i).getDate())) {
					System.out.println("------------------------------------------");
					System.out.println(meals.get(i).toString());
					System.out.println("------------------------------------------");
				}
			}
		} catch (DateTimeException ex) {
			System.out.println(">>>>Wrong parameters");
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
