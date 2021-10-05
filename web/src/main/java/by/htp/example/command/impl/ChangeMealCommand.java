package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ChangeMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String timeS = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String caloriesS = request.getParameter(RequestParameterName.REQ_PARAM_CALORIES);
        try {
            int id = Integer.parseInt(idS);
            LocalDate date = LocalDate.parse(dateS);
            LocalDate checkDateAfter = LocalDate.of(2021, 10, 04);
            LocalTime time = LocalTime.parse(timeS);
            double weight = Integer.parseInt(weightS);
            double calories = Integer.parseInt(caloriesS);
            MealService mealService = provider.getServiceMeal();
            Meal meal = new Meal(id, date, time, weight, calories);

            if(meal !=null) {

                mealService.changeMealCharacteristic(meal);
                request.setAttribute(RequestParameterName.REQ_PARAM_CHANGE_MEAL, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.CHANGE_MEAL);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {

        }
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
