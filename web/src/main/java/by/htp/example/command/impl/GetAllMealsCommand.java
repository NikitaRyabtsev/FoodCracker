package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.command.Command;
import by.htp.example.command.CommandHelper;
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
import java.security.Provider;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class GetAllMealsCommand implements Command {
    CommandHelper helper = CommandHelper.getInstance();
    ServiceProvider provider = ServiceProvider.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Meal> meals;
        String getmeals = request.getParameter(RequestParameterName.REQ_PARAM_GET_MEALS);
        MealService mealService = provider.getServiceMeal();
        try {
            meals = mealService.getMeals();
            request.setAttribute("getMeals", meals);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_MEALS_JSP);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {

            e.printStackTrace();

        }
//        ServiceProvider provider = ServiceProvider.getInstance();
//        try {
//            ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
//            displayMeals(meals);
//        } catch (InputMismatchException | IllegalArgumentException | ServiceException e) {
//            System.out.println(">>>Wrong choose , try again");
//        }
    }
}
