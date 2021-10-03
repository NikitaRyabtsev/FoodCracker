package by.htp.example.command.impl;

import by.htp.example.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int userChoose;
//        LocalDate date;
//        LocalTime time;
//        double weight;
//        double calories;
//        try {
//            ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
//            displayMeals(meals);
//            System.out.println("Input number of Meal you want to change : ");
//            userChoose = Util.scanInt();
//            displayMeals(meals);
//            Meal currentMeal = meals.get(userChoose - 1);
//            System.out.println("Input number of characterisic you want to chang : ");
//            System.out.println("#1 Change date : ");
//            System.out.println("#2 Change time : ");
//            System.out.println("#3 Change weight : ");
//            System.out.println("#4 Change calories : ");
//            System.out.println("#5 Previous menu : ");
//
//            userChoose = Util.scanInt();
//
//            if (userChoose < 1 || userChoose > 5) {
//                throw new IllegalArgumentException();
//            }
//
//            switch (userChoose) {
//                case 1:
//                    date = Util.scanDate();
//                    currentMeal.setDate(date);
//                    break;
//                case 2:
//                    System.out.println("Input time: ");
//                    time = Util.scanTime();
//                    currentMeal.setTime(time);
//                    break;
//                case 3:
//                    System.out.println("Input weight: ");
//                    weight = scan.nextDouble();
//                    currentMeal.setWeight(weight);
//                    break;
//                case 4:
//                    System.out.println("Input calories");
//                    calories = scan.nextDouble();
//                    currentMeal.setCalories(calories);
//                case 5:
//                    break;
//                default:
//                    System.out.println(">>>Wrong choose");
//
//            }
//            provider.getServiceMeal().changeMealCharacteristic(currentMeal);
//        } catch (InputMismatchException | IllegalArgumentException | DateTimeException ex) {
//            System.out.println(">>> Wrong choose");
//        } catch (ServiceException e) {
//            System.out.println(">>>[Error] Something wrong in method changeMealCharacteristic()");
//        }
//
//        return null;
    }
}
