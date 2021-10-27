package by.htp.example.view;

import by.htp.example.MealService;
import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.impl.MealServiceImpl;
import by.htp.example.util.Util;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ViewMenuConsole {


    private MealService mealService = new MealServiceImpl();

    private Scanner scan;

    public void viewMenuConsole() {
        int userChoose = 0;
        String userId = "4";
        while (userChoose != 7) {
            try {
                showMenu();
                userChoose = Util.scanInt();

                switch (userChoose) {
                    case 1://
                        displayMeals( mealService.getMeals(userId));
                        break;
                    case 2://
                        System.out.println( mealService.createMeal(String.valueOf(Util.scanDate())
                                , String.valueOf(Util.scanTime()), userId));
                        break;
                    case 3:
                        mealService.changeMealCharacteristic(String.valueOf
                                (Util.scanDate()), String.valueOf(Util.scanTime()), userId);
                        break;
                    case 4:
                        mealService.deleteMeal(String.valueOf(Util.scanInt()));
                        break;
                    case 5:
                        displayMeals( mealService.getMeals(userId));
                        System.out.println( mealService.getMealById(String.valueOf(Util.scanInt())));
                        break;
                    case 6:
                        displayMeals( mealService.getMealByDate(String.valueOf(Util.scanDate())));
                        break;
                    case 7:
                        System.out.println("Goodbye");
                        break;

                    default:
                        System.out.println(">>>[Info] Wrong choose");
                }
            } catch (InputMismatchException | DateTimeException | IllegalArgumentException | ServiceException ex) {
                ex.getMessage();
            }
        }
    }


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

    private void displayMeals(List<Meal> meals) {

        if (meals != null && !meals.isEmpty()) {
            for (int i = 0; i < meals.size(); i++) {
                System.out.println(
                        "#" + meals.get(i).getId() + " Meals Date: " + meals.get(i).getDate() + " Time: " + meals.get(i).getTime());
            }
        }
    }
}
