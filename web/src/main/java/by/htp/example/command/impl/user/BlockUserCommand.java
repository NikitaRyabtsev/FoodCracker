package by.htp.example.command.impl.user;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.*;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockUserCommand implements Command {
    @Inject
    private UserService userService;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        userService = provider.getUserService();
        User user = null;
        String block = request.getParameter(RequestParameterName.REQ_PARAM_BLOCK_USER);
        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        try {
            user = new User(Integer.parseInt(id), block);
            if (user != null) {
                userService.blockUser(user);
                request.setAttribute(RequestParameterName.REQ_PARAM_BLOCK_USER, user);
                CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_ALL_USERS)).execute(request,response);
            }
        } catch (ServiceException | DaoException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
            e.printStackTrace();
        }

    }
}
