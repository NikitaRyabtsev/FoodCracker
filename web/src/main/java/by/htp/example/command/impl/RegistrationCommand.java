package by.htp.example.command.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        User user;
        ServiceProvider provider = ServiceProvider.getInstance();

        String login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);
        String email = request.getParameter(RequestParameterName.REQ_PARAM_EMAIL);
        String name = request.getParameter(RequestParameterName.REQ_PARAM_NAME);
        String secondName = request.getParameter(RequestParameterName.REQ_PARAM_SECOND_NAME);
        String weightS = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String sex = request.getParameter(RequestParameterName.REQ_PARAM_SEX);
        String dateOfBirthS = request.getParameter(RequestParameterName.REQ_PARAM_DATE_OF_BIRTH);
        String role = request.getParameter(RequestParameterName.REQ_PARAM_ROLE);
        try {

            double weight = Integer.parseInt(weightS);
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthS);

            user = new User(login, password, email, name, secondName, weight, sex, dateOfBirth, role);

            provider.getUserService().registration(user);

            request.setAttribute(RequestParameterName.REQ_PARAM_REGISTRATION, user);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_REGISTRATION);
            dispatcher.forward(request, response);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
