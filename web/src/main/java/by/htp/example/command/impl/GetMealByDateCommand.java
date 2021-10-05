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

public class GetMealByDateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);

        LocalDate date = LocalDate.parse(dateS);
        MealService mealService = provider.getServiceMeal();
        Meal meal;
        try {
            meal = mealService.getMealByDate(date);
            if (meal != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_MEAL_BY_DATE, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_MEAL);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
