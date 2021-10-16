package by.htp.example.command.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.Role;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetUsersCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        User user = null;

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        List<User> users;

        HttpSession session = request.getSession(false);
        if (session != null) {
            user = (User) session.getAttribute(RequestParameterName.REQ_SESSION_USER);
        }
        try {
            if (user != null) {
                users = userService.getUsers();
                if (users != null | !users.isEmpty()) {
                    if (Role.ADMIN.toString().equalsIgnoreCase(user.getRole())) {
                        request.setAttribute(RequestParameterName.REQ_PARAM_GET_USERS, users);
                        RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_USERS);
                        dispatcher.forward(request, response);
                    }
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
            dispatcher.forward(request, response);
        }

    }
}
