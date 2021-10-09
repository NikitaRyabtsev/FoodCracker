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
import java.time.format.DateTimeParseException;

public class ChangeMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
       // String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String timeS = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String caloriesS = request.getParameter(RequestParameterName.REQ_PARAM_CALORIES);
        try {
           // int id = Integer.parseInt(idS);
            LocalDate date = LocalDate.parse(dateS);
            LocalTime time = LocalTime.parse(timeS);
            double weight = Integer.parseInt(weightS);
            double calories = Integer.parseInt(caloriesS);
            LocalDate checkDateBefore = LocalDate.of(2021, 10, 04);
            LocalDate checkDateAfter = LocalDate.of(2021, 12, 31);
            MealService mealService = provider.getServiceMeal();

            Meal meal = new Meal( date, time, weight, calories);

           // meal.setId(id);
            meal.setDate(date);
            meal.setTime(time);
            meal.setWeight(weight);
            meal.setCalories(calories);

            if (meal != null) {
                if (date.isAfter(checkDateAfter) | date.isBefore(checkDateBefore)) {
                    mealService.changeMealCharacteristic(meal);
                    request.setAttribute(RequestParameterName.REQ_PARAM_CHANGE_MEAL, meal);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.CHANGE_MEAL);
                    dispatcher.forward(request, response);
                }
            } else {

                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
                throw new NumberFormatException();

            }
        } catch (ServiceException |NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }
    }
}
