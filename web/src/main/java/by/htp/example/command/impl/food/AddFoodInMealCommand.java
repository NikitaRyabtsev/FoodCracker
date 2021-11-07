package by.htp.example.command.impl.food;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.FoodService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.command.*;

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
            CommandHelper.getInstance().getCommand(CommandName.GET_ALL_FOOD.toString()).execute(request, response);
        } catch (ServiceException | DaoException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
            dispatcher.forward(request, response);
            e.printStackTrace();
        }

    }
}
