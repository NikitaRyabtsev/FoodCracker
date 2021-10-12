package by.htp.example.command.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.Role;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ToEditProfileCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        ServiceProvider provider = ServiceProvider.getInstance();

        User user = null;
        HttpSession session = request.getSession(false);

        if (session != null) {
            user = (User) session.getAttribute(RequestParameterName.REQ_SESSION_USER);
        }
        if (user != null) {
            String id = request.getParameter(RequestParameterName.REQ_PARAM_ID);
            try{

                if(user.getRole().equals(Role.ADMIN.toString())){
                    user = provider.getUserService().getAdminAccessInfo(id);
                    request.setAttribute("info",user);

                }
            }catch(ServiceException e){
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        }

    }
}
