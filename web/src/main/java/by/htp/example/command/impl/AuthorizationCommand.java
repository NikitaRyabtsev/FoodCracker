package by.htp.example.command.impl;

import by.htp.example.UserService;
import by.htp.example.command.RequestParameterName;
import by.htp.example.command.Status;
import by.htp.example.bean.user.User;
import by.htp.example.ServiceException;
import by.htp.example.ServiceProvider;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationCommand implements Command {

    ServiceProvider provider = ServiceProvider.getInstance();
    @Inject
    private UserService userService;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user;

        ServiceProvider provider = ServiceProvider.getInstance();
        HttpSession session = request.getSession(false);
        if(session!=null){
            session = request.getSession(true);
        }

        String login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);
        try {
            userService = provider.getUserService();
            user = userService.authorization(login, password);

            if (user != null) {
                if(Status.UNBLOCK.toString().equalsIgnoreCase(user.getBlock())) {
                    session.setAttribute(RequestParameterName.REQ_SESSION_USER, user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_INDEX_JSP);
                    dispatcher.forward(request, response);
                }else if(Status.BLOCK.toString().equalsIgnoreCase(user.getBlock())){
                    request.setAttribute("blocked", "true");
                    RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
                    dispatcher.forward(request, response);
                }
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
                dispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.ERROR_PAGE_JSP);
            dispatcher.forward(request, response);

        }


    }
}
