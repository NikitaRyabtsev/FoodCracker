package by.htp.example.command.impl.meal;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.*;
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

        try {
            mealService.createMeal(date, time, id);
            CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_ALL_MEALS)).execute(request,response);
        } catch (ServiceException | DaoException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }

    }

}

