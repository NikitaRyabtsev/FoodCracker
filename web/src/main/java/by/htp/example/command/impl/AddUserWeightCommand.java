package by.htp.example.command.impl;

import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.FoodService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserWeightCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        User user;

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String weight = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);

        try {
            user = userService.addUserWeight(id, weight,date);
            if (user != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_ADD_USER_WEIGHT, user);
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
