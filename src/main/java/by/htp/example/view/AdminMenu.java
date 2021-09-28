package by.htp.example.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.service.impl.SQLMealService;

public class AdminMenu {

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
					instance.getServiceMeal().getMeals();
					break;
				case 2:
//					meals.add(mealService.createMeal());
//					break;
//				case 3:
//					meals = mealService.changeMealCharacteristic(meals);	
//					break;
//				case 4:
//					meals = mealService.deleteMeal(meals);
					break;
				case 5:
					instance.getServiceMeal().getMealById();
					break;
				case 6:
					instance.getServiceMeal().getMealByDate();
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
	
	

}
