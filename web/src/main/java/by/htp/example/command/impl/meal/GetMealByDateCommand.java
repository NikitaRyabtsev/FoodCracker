package by.htp.example.command.impl.meal;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class GetMealByDateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        MealService mealService = provider.getServiceMeal();
        String keyUserId = request.getParameter(RequestParameterName.REQ_PARAM_ID);

        List<Meal> meals;
        HttpSession session = request.getSession(false);
        if (session != null) {
            session = request.getSession(true);
        }

        try {
            meals = mealService.getMealByDate(date,keyUserId);
            session.getAttribute(RequestParameterName.REQ_SESSION_USER);
            if (meals != null | meals.isEmpty()) {
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_MEAL_BY_DATE, meals);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_MEALS_JSP);
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(JSPPageName.USER_INDEX_JSP);
            }
        } catch (ServiceException | DateTimeParseException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
            dispatcher.forward(request, response);
        }

    }
}
