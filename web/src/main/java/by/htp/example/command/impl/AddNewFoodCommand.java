package by.htp.example.command.impl;

import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.command.Role;
import by.htp.example.service.FoodService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddNewFoodCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {

        ServiceProvider provider = ServiceProvider.getInstance();
        FoodService foodService = provider.getFoodService();
        String name = request.getParameter(RequestParameterName.REQ_PARAM_GET_NAME);
        String calories = request.getParameter(RequestParameterName.REQ_PARAM_GET_CALORIES);
        String proteins = request.getParameter(RequestParameterName.REQ_PARAM_GET_PROTEINS);
        String fats = request.getParameter(RequestParameterName.REQ_PARAM_GET_FATS);
        String carbohydrates = request.getParameter(RequestParameterName.REQ_PARAM_GET_CARBOHYDRATES);
        User user = null;

        HttpSession session = request.getSession(false);
        if (session != null) {
            user = (User) session.getAttribute(RequestParameterName.REQ_SESSION_USER);
        }
        if(user!=null) {
            Food food = new Food(name,Double.parseDouble(calories),Double.parseDouble(proteins),
                    Double.parseDouble(fats),Double.parseDouble(carbohydrates));
            try {
                if (Role.USER_PRO.toString().equalsIgnoreCase(user.getRole())
                        | Role.ADMIN.toString().equalsIgnoreCase(user.getRole())) {
                    foodService.createFood(food);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                    dispatcher.forward(request, response);
                }else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                    dispatcher.forward(request, response);
                }
            } catch (ServiceException e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
                e.printStackTrace();
            }
        }
    }
}
