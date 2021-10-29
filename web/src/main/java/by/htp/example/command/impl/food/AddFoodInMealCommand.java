package by.htp.example.command.impl.food;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.*;
import by.htp.example.FoodService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddFoodInMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        FoodService foodService = provider.getFoodService();

        String keyMealId = request.getParameter(RequestParameterName.REQ_PARAM_ADD_FOOD_ID_MEAL);
        String keyFoodId = request.getParameter(RequestParameterName.REQ_PARAM_ADD_FOOD_ID);

        try {
            foodService.addFoodInMeal(keyMealId, keyFoodId);
            CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_ALL_FOOD)).execute(request,response);
        } catch (ServiceException | DaoException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
            e.printStackTrace();
        }
    }
}
