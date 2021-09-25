package by.htp.example.logic.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.logic.MealService;



public class RestaurantService implements MealService {

	private Scanner scan;

	public void getMeals(ArrayList<Meal> meals) {

		scan = new Scanner(System.in);

		int userChoose;
		try {
			while (true) {
				showMenu(meals);
				userChoose = scan.nextInt();
				if (userChoose < 1 || userChoose > meals.size() + 2) {
					throw new IllegalArgumentException();
				}
				if (userChoose == meals.size() + 1) {
					break;
				}
				System.out.println(meals.get(userChoose - 1).toString());
				System.out.println("--------------------------");

			}
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.out.println(">>> Wrong choose, try again");
		}
	}

	private void showMenu(ArrayList<Meal> meals) {
		System.out.println("For more information choose a meal:");

		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				System.out.println((i + 1) + ". " + "Meal # " + (i + 1) + meals.get(i));
			}
			System.out.println((meals.size() + 1) + ". Previous menu");

		}
	}

	@Override
	public Meal createMeal() {
		scan = new Scanner(System.in);
		String date = null;
		String time = null;
		double weight = 0;
		double calories = 0;

		System.out.println("Input date yyyy.MM.dd");
		date = scan.next();
	//	Util.scanData();
		System.out.println("Input time [hh.mm]");
		time = scan.next();
		System.out.println("Input weight");
		weight = scan.nextDouble();
		System.out.println("Input calories");
		calories = scan.nextDouble();

		Meal meal = new Meal(date, time, weight, calories);
		System.out.println(meal.toString());

		return meal;

	}

	@Override
	public ArrayList<Meal> changeMealCharacteristic(ArrayList<Meal> meals) {
		scan = new Scanner(System.in);

		int userChoose;
		String name = null;
		String date = null;
		String time = null;
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
					date = scan.next();
					currentMeal.setDate(date);
					break;
				case 2:
					System.out.println("Input time: ");
					time = scan.next();
					currentMeal.setTime(time);
					break;
				case 3:
					System.out.println("Input weight: ");
					weight = scan.nextDouble();
					currentMeal.setWeight(weight);
					break;
				case 4:
					System.out.println("Input date");
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
				System.out.println((i + 1) + ". " + "Meal # " + (i + 1) + meals.get(i));
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
}
