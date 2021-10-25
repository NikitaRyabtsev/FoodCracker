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

public class GetUserWeightCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        String date = request.getParameter(RequestParameterName.REQ_PARAM_DATE);
        User user = null;
        try{
            user = userService.getWeightFromDB(id,date);
            if(user != null){
                request.setAttribute(RequestParameterName.REQ_PARAM_GET_USER_WEIGHT, user);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_ALL_USERS);
                dispatcher.forward(request, response);
            }else {
                response.sendRedirect(JSPPageName.USER_INDEX_JSP);
            }
        }catch(ServiceException e){
            response.sendRedirect(JSPPageName.ERROR_PAGE_JSP);
            e.printStackTrace();
        }
    }
}
