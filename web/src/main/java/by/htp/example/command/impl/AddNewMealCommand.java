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

public class AddNewMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException {

        ServiceProvider provider = ServiceProvider.getInstance();
        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String timeS = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String caloriesS = request.getParameter(RequestParameterName.REQ_PARAM_CALORIES);
        int id = Integer.parseInt(idS);
        LocalDate date = LocalDate.parse(dateS);
        LocalDate checkDateAfter = LocalDate.of(2021, 10, 04);
        LocalTime time = LocalTime.parse(timeS);
        double weight = Integer.parseInt(weightS);
        double calories = Integer.parseInt(caloriesS);
        MealService mealService = provider.getServiceMeal();

        Meal meal = new Meal(id, date, time, weight, calories);

        try {
            mealService.createMeal(meal);
            request.setAttribute(RequestParameterName.REQ_PARAM_ADD_MEAL, meal);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ADD_NEW_MEAl_JSP);
            dispatcher.forward(request, response);



        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
