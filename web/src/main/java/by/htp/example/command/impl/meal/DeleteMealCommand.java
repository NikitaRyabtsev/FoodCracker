package by.htp.example.command.impl.meal;

import by.htp.example.MealService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.*;
import by.htp.example.bean.Meal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        MealService mealService = provider.getServiceMeal();

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        try {
            mealService.deleteMeal(id);
            if (id != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_DELETE_MEAL,id);
                response.sendRedirect(JSPPageName.USER_INDEX_JSP);
            } else {
                response.sendRedirect(JSPPageName.USER_INDEX_JSP);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
            dispatcher.forward(request, response);
        }
    }

}

