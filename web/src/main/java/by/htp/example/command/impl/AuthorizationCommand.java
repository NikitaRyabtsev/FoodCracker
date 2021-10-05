package by.htp.example.command.impl;

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
import java.io.IOException;

public class AuthorizationCommand implements Command {

    ServiceProvider provider = ServiceProvider.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);

        UserService userService = provider.getUserService();
        User user;
        try {
            user = userService.authorization(login, password);
            request.setAttribute(RequestParameterName.REQ_PARAM_USER, user);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
            dispatcher.forward(request, response);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
