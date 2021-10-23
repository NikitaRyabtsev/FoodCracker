package by.htp.example.command.impl;

import by.htp.example.ServiceProvider;
import by.htp.example.UserService;
import by.htp.example.command.RequestParameterName;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.ServiceException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegistrationCommand implements Command {
    @Inject
    private UserService userService;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user;
        double weight;
        ServiceProvider provider = ServiceProvider.getInstance();

        String login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);
        String email = request.getParameter(RequestParameterName.REQ_PARAM_EMAIL);
        String name = request.getParameter(RequestParameterName.REQ_PARAM_NAME);
        String secondName = request.getParameter(RequestParameterName.REQ_PARAM_SECOND_NAME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_USER_WEIGHT);
        String sex = request.getParameter(RequestParameterName.REQ_PARAM_SEX);
        String dateOfBirthS = request.getParameter(RequestParameterName.REQ_PARAM_DATE_OF_BIRTH);
        String block = request.getParameter(RequestParameterName.REQ_PARAM_BLOCK_USER);
        String role = request.getParameter(RequestParameterName.REQ_PARAM_ROLE);

        try {
            weight = Integer.parseInt(weightS);
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthS);

            user = new User(login, password, email, name, secondName, weight, sex, dateOfBirth, role, block);
            if (user != null) {
                userService = provider.getUserService();
                userService.registration(user);
                request.setAttribute(RequestParameterName.REQ_PARAM_REGISTRATION, user);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException | DateTimeParseException | NumberFormatException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);

        }
    }
}
