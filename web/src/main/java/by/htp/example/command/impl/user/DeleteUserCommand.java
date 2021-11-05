package by.htp.example.command.impl.user;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;
import by.htp.example.bean.user.User;
import by.htp.example.command.*;
import by.htp.example.bean.dao.DaoException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        User user;
        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);

        try {
            int id = Integer.parseInt(idS);
            user = new User(id);
            if (user != null) {
                userService.deleteUser(user);
                request.setAttribute(RequestParameterName.REQ_PARAM_DELETE_USER, user);
                CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_ALL_USERS)).execute(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
                dispatcher.forward(request, response);

            }

        } catch (ServiceException | NumberFormatException | DaoException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
        }
    }
}

