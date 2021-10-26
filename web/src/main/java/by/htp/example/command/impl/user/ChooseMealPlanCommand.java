package by.htp.example.command.impl.user;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChooseMealPlanCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String mealPlanId = request.getParameter("mealPlanId");
        try {
            userService.chooseMealPlan(mealPlanId, id);
            response.sendRedirect(JSPPageName.USER_INDEX_JSP);
        } catch (ServiceException e) {
            response.sendRedirect(JSPPageName.ERROR_PAGE_JSP);
            e.printStackTrace();
        }

    }
}
