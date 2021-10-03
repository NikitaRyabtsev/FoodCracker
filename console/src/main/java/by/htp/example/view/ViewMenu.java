package by.htp.example.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.util.Util;

public class ViewMenu{

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

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				case 7:
					System.out.println("Goodbye");
					break;

				default:
					System.out.println(">>>[Info] Wrong choose");
				}

			} catch (InputMismatchException | IllegalArgumentException ex) {

			}
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
