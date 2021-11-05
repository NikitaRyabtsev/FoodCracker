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

public class AddUserWeightCommand implements Command {
    @Inject
    private UserService userService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();
        userService = provider.getUserService();

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String weight = request.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);

        try {
            userService.addUserWeight(id, weight, date);
            CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_WEIGHT)).execute(request, response);
        } catch (ServiceException | DaoException | NumberFormatException e) {
            request.setAttribute("wrong" , " true");
            CommandHelper.getInstance().getCommand(String.valueOf(CommandName.TO_EDIT_PROFILE)).execute(request, response);
            e.printStackTrace();
        }
    }
}
