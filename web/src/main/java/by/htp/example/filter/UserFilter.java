package by.htp.example.filter;

import by.htp.example.bean.user.User;
import by.htp.example.command.CommandName;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        User user = null;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if(session == null){
            session = req.getSession(true);
        }
        String url = req.getRequestURI();
        System.out.println(url);

        String param =  req.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);

        if (session.getAttribute(RequestParameterName.REQ_SESSION_USER) != null) {
            chain.doFilter(req, resp);
        } else if (CommandName.AUTHORIZATION.toString().equalsIgnoreCase(param)) {
                chain.doFilter(req, resp);
        } else if (CommandName.REGISTRATION.toString().equalsIgnoreCase(param)){
            chain.doFilter(req,resp);
        } else if (CommandName.GO_TO_REGISTRATION.toString().equalsIgnoreCase(param)) {
            chain.doFilter(req,resp);
        } else {
            req.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP).forward(req, resp);
        }
    }


    @Override
    public void destroy() {

    }
}
