package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.Role;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();
        List<User> users;
        UserService userService = provider.getUserService();

        try {
            users = userService.getUsers();

                if (users != null | !users.isEmpty()) {

                request.setAttribute(RequestParameterName.REQ_PARAM_GET_USERS, users);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_USERS);
                dispatcher.forward(request, response);
            } else {

                request.setAttribute(RequestParameterName.REQ_PARAM_INCORRECT, users);
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
