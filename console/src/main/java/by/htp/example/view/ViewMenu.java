package by.htp.example.view;

import by.htp.example.MealService;
import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceProvider;
import by.htp.example.bean.Meal;
import by.htp.example.impl.MealServiceImpl;
import by.htp.example.util.Util;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewMenu{

//    @Inject
//    private MealServiceRemote mealServiceRemote = new MealServiceImpl();
//
//    private Scanner scan;
//
//	public void viewMenu() {
//		int userChoose = 0;
//
//		while (userChoose != 7) {
//			try {
//				showMenu();
//				userChoose = Util.scanInt();
//
//				switch (userChoose) {
//				case 1:
//					mealServiceRemote.getMeals();
//					break;
//				case 2:
//					mealServiceRemote.createMeal();
//					break;
//				case 3:
//					mealServiceRemote.changeMealCharacteristic()
//					break;
//				case 4:
//					mealServiceRemote.deleteMeal()
//					break;
//				case 5:
//					mealServiceRemote.getMealById();
//					break;
//				case 6:
//					mealServiceRemote.getMealByDate();
//					break;
//				case 7:
//					System.out.println("Goodbye");
//					break;
//
//				default:
//					System.out.println(">>>[Info] Wrong choose");
//				}
//			} catch (InputMismatchException | IllegalArgumentException ex) {
//
//			}
//		}
//	}
//


	private void showMenu() {
		System.out.println("Choose your options : ");
		System.out.println("1. Просмотерть все приёмы пищи");
		System.out.println("2. Добавить приём пищи");
		System.out.println("3. Изменить приём пищи");
		System.out.println("4. Удалить приём пищи");
		System.out.println("5. Выбрать приём пищи по номеру");
		System.out.println("6. Выбрать приём пищи по дате");
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
