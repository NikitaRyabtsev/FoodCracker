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

public class AddNewMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        MealService mealService = provider.getServiceMeal();
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        String time = request.getParameter(RequestParameterName.REQ_PARAM_TIME);
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        Meal meal = null;
        try {
            meal = mealService.createMeal(date, time, id);
            if(meal!=null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_ADD_MEAL, meal);
                response.sendRedirect(JSPPageName.GET_ALL_MEALS_JSP);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }

    }

}

