package by.htp.example.command.impl;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.bean.Meal;
import by.htp.example.MealService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAllMealsCommand implements Command {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        MealService mealService = provider.getServiceMeal();
        List<Meal> meals;
        String keyUserId = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        HttpSession session = request.getSession(false);
        if(session!=null){
            session = request.getSession(true);
        }

        try {
            meals = mealService.getMeals(keyUserId);
            session.getAttribute(RequestParameterName.REQ_SESSION_USER);
            if (meals != null | !meals.isEmpty()) {
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_MEALS, meals);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_MEALS_JSP);
                dispatcher.forward(request, response);
            } else {
                request.setAttribute(RequestParameterName.REQ_PARAM_INCORRECT, meals);
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
