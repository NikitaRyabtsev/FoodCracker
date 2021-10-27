package by.htp.example.command.impl.user;

import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserWeightCommand implements Command {
    @Inject
    private UserService userService;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ServiceProvider provider = ServiceProvider.getInstance();
        userService = provider.getUserService();

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String weight = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);

        try {
            userService.addUserWeight(id, weight,date);
            response.sendRedirect(JSPPageName.USER_INDEX_JSP);
        } catch (ServiceException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);
            e.printStackTrace();
        }
    }
}
