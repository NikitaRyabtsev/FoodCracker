package by.htp.example.logic;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;

public class MealService {

	public void getMeals(ArrayList<Meal> meals) {

		Scanner scan = new Scanner(System.in);

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
		System.out.println("For more infotmation choose a meal:");
		try {
		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				System.out.println((i + 1) + ". " + meals.get(i).getName());
			}
			System.out.println((meals.size() + 1) + ". Previous menu");
			throw new IndexOutOfBoundsException();
		}
		}catch(IndexOutOfBoundsException e) {
			System.out.println(">>> Wrong choose , try again");
			}
		}
}