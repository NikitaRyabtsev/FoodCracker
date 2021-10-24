package by.htp.example.command.impl.food;

import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.FoodService;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddFoodInMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ServiceProvider provider = ServiceProvider.getInstance();
        FoodService foodService = provider.getFoodService();

        String keyMealId = request.getParameter(RequestParameterName.REQ_PARAM_ADD_FOOD_ID_MEAL);
        String keyFoodId = request.getParameter(RequestParameterName.REQ_PARAM_ADD_FOOD_ID);
        List<Food> foods;
        try{
            foods = foodService.addFoodInMeal(keyMealId,keyFoodId);
            if(foods!=null | !foods.isEmpty()){
                request.setAttribute(RequestParameterName.REQ_PARAM_ADD_FOOD_IN_MEAL, foods);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                dispatcher.forward(request, response);
            }
        }catch(ServiceException e){
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
            e.printStackTrace();
        }
    }
}