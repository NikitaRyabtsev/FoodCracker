package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.MealService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;

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
        MealService mealService = provider.getServiceMeal();
        Meal meal = null;
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String time = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        try {
            meal = mealService.changeMealCharacteristic(id, date, time);
            if (meal != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_CHANGE_MEAL, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.CHANGE_MEAL);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }
    }
}
