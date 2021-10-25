package by.htp.example.view;

import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.dto.MealWSAdapter;
import by.htp.example.soap.ServiceException_Exception;
import by.htp.example.soap.SoapMealService;
import by.htp.example.soap.Ws_002fMeal;
import by.htp.example.util.Util;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.List;

public class ViewMenuSoap {

    public void viewSoap() throws ServiceException_Exception {

    Ws_002fMeal mealsWSFactory = new Ws_002fMeal();
    SoapMealService mealWS = mealsWSFactory.getSoapMealServicePort();

        int userChoose = 0;
        String userId = "4";
        while (userChoose != 7) {
            try {
                showMenu();
                userChoose = Util.scanInt();

                switch (userChoose) {
                    case 1://
                        displayMeals(mealWS.getMeals(userId));
                        break;
                    case 2://
                        System.out.println(new MealWSAdapter().transformMeal(mealWS.addMeal(String.valueOf(Util.scanDate())
                                , String.valueOf(Util.scanTime()), userId)));
                        break;
                    case 3:
                        mealWS.changeMeal(String.valueOf
                                (Util.scanDate()), String.valueOf(Util.scanTime()), userId);
                        break;
                    case 4:
                        mealWS.deleteMeal(String.valueOf(Util.scanInt()));
                        break;
                    case 5:
                        displayMeals(mealWS.getMeals(userId));
                        System.out.println(new MealWSAdapter()
                                .transformMeal(mealWS.getMealById(String.valueOf(Util.scanInt()))));
                        break;
                    case 6:

                        displayMeals(mealWS.getMealsByDate(String.valueOf(Util.scanDate())));
                        break;
                    case 7:
                        System.out.println("Goodbye");
                        break;

                    default:
                        System.out.println(">>>[Info] Wrong choose");
                }
            } catch (InputMismatchException | DateTimeException | IllegalArgumentException ex) {
                ex.getMessage();
            }
        }

}

    private void displayMeals(List<by.htp.example.soap.Meal> meals) {
        if (meals != null && !meals.isEmpty()) {
            for (int i = 0; i < meals.size(); i++) {
                System.out.println(
                        "#" + (i + 1) + " Meals Date: " + meals.get(i).getDateOfEating() + " Time: " + meals.get(i).getTimeOfEating());
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

}
