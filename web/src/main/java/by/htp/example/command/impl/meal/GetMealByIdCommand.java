package by.htp.example.command.impl.meal;

import by.htp.example.MealService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.bean.Meal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMealByIdCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        MealService mealService = provider.getServiceMeal();
        Meal meal;
        try {
            meal = mealService.getMealById(id);
            if (meal != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_MEAL_BY_ID, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_MEAL);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }

    }
}
