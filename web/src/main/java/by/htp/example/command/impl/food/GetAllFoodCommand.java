package by.htp.example.command.impl.food;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.bean.Food;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.FoodService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllFoodCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        FoodService foodService = provider.getFoodService();
        List<Food> foods;

        try{
            foods = foodService.getAllFood();

            if(foods!=null | !foods.isEmpty()){
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_FOODS, foods);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_FOOD);
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        }catch(ServiceException e){
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);

        }
    }
}
