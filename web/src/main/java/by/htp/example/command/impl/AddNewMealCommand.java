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

public class AddNewMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        ServiceProvider provider = ServiceProvider.getInstance();
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String timeS = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);

        try {

            LocalDate date = LocalDate.parse(dateS);
            LocalTime time = LocalTime.parse(timeS);
            double weight = Integer.parseInt(weightS);
            MealService mealService = provider.getServiceMeal();


                Meal meal = new Meal(date, time, weight,Integer.parseInt(id));
                mealService.createMeal(meal);
                request.setAttribute(RequestParameterName.REQ_PARAM_ADD_MEAL, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_MEALS_JSP);
                dispatcher.forward(request, response);

        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }

    }

}

