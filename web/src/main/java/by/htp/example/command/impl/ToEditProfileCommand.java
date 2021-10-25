package by.htp.example.command.impl;

import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.UserService;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.command.Role;
import by.htp.example.bean.dao.DaoException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToEditProfileCommand implements Command {
    @Inject
    private UserService userService;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ServiceProvider provider = ServiceProvider.getInstance();
        userService = provider.getUserService();
        User user = null;
        HttpSession session = request.getSession(false);

        if (session != null) {
            user = (User) session.getAttribute(RequestParameterName.REQ_SESSION_USER);
        }
        if (user != null) {
            String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
            String weightId = request.getParameter("idWeight");
            try {
                if (Role.ADMIN.toString().equalsIgnoreCase(user.getRole())) {
                    user = userService.getAdminAccessInfo(Integer.parseInt(id));
                    request.setAttribute(RequestParameterName.REQ_PARAM_TO_EDIT_PROFILE, user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ADMIN_PROFILE);
                    dispatcher.forward(request, response);

                } else{
                    System.out.println(weightId);
                    user = userService.getUserAccessInfo(weightId,id);
                    request.setAttribute(RequestParameterName.REQ_PARAM_TO_EDIT_PROFILE, user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_PROFILE);
                    dispatcher.forward(request, response);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                dispatcher.forward(request, response);
            } catch (ServiceException |NumberFormatException e) {
                e.printStackTrace();
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        }

    }
}
