package by.htp.example.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.logic.MealService;

public class AdminMenu {

	public void viewMenu() {

		Scanner scan = new Scanner(System.in);

		ArrayList<Meal> meals = init();
		MealService mealService = new MealService();
		int userChoose = 0;

		while (userChoose != 2) {
			try {
				showMenu();
				userChoose = scan.nextInt();

				switch (userChoose) {
				case 1:
					mealService.getMeals(meals);
					break;
				case 2:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println(">>> Wrong choose");
				}
			} catch (InputMismatchException | IllegalArgumentException ex) {
				System.out.println(">>> Wrong choose");
			}
		}

	}

	private ArrayList<Meal> init() {

		ArrayList<Meal> meals = new ArrayList<>();

		Meal meal = new Meal("Завтрак", "2020-01-01", 500, 300);
		meals.add(meal);

		return meals;
	}

	private void showMenu() {
		System.out.println("Hello , pls choose your options : ");
		System.out.println("1. See all meals");
		System.out.println("2. Exit");
	}
	
	private Meal addMeal(ArrayList<Meal> meals) {
		
		
		return null;
		
	}

}
