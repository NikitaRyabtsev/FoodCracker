package by.htp.example.command.impl.user;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class EditProfileCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        User user = null;
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);
        String name = request.getParameter(RequestParameterName.REQ_PARAM_NAME);
        String secondName = request.getParameter(RequestParameterName.REQ_PARAM_SECOND_NAME);
        String email = request.getParameter(RequestParameterName.REQ_PARAM_EMAIL);
        String sex = request.getParameter(RequestParameterName.REQ_PARAM_SEX);
        String dateOfBirth = request.getParameter(RequestParameterName.REQ_PARAM_DATE_OF_BIRTH);

        try {
            user = userService.EditProfileInDB(login, password, name, secondName, email, sex, dateOfBirth, id);
            if (user != null) {
                request.setAttribute(RequestParameterName.REQ_PARAM_CHANGE_USER_PROFILE, user);
                response.sendRedirect(JSPPageName.USER_PROFILE);
            }
        } catch (ServiceException | NumberFormatException e) {
            request.setAttribute(RequestParameterName.REQ_PARAM_LOGIN,"true");
            e.printStackTrace();
            CommandHelper.getInstance().getCommand(String.valueOf(CommandName.EDIT_PROFILE)).execute(request, response);
        }
    }
}
