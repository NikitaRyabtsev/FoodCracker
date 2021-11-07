package by.htp.example.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import by.htp.example.bean.Meal;
import by.htp.example.logic.MealService;
import by.htp.example.logic.impl.RestaurantService;

public class AdminMenu {

    public void viewMenu() {

        Scanner scan = new Scanner(System.in);
        ArrayList<Meal> meals = init();
        MealService mealService = new RestaurantService();
        int userChoose = 0;

        while (userChoose != 5) {
            try {
                showMenu();
                userChoose = scan.nextInt();

                switch (userChoose) {
                    case 1:
                        mealService.getMeals(meals);
                        break;
                    case 2:
                        meals.add(mealService.createMeal());
                        break;
                    case 3:
                        meals = mealService.changeMealCharacteristic(meals);
                        break;
                    case 4:
                        meals = mealService.deleteMeal(meals);
                        break;
                    case 5:
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

        Meal meal = new Meal("2020-01-01", "7.30 ", 500, 300);
        meals.add(meal);

        meal = new Meal("2022-02-02", "12.30 ", 10000, 100300);
        meals.add(meal);

        return meals;
    }

    private void showMenu() {
        System.out.println("Choose your options : ");
        System.out.println("1. See all meals");
        System.out.println("2. Add meal");
        System.out.println("3. Change characteristic");
        System.out.println("4. Delete meal");
        System.out.println("5. Exit");
    }


}
