package by.htp.example.filter;

//import by.htp.example.command.JSPPageName;
//import by.htp.example.command.RequestParameterName;
//import by.htp.example.service.MealService;
//import by.htp.example.service.ServiceProvider;
//import by.htp.example.service.UserService;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class UserFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
////        HttpServletRequest req = (HttpServletRequest) request;
////        HttpServletResponse resp = (HttpServletResponse) response;
////        HttpSession session = req.getSession(true);
////        String login = req.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
////        String password = req.getParameter(RequestParameterName.REQ_PARAM_PASS);
////        if(session.getAttribute(RequestParameterName.REQ_PARAM_LOGIN) != null
////                && session.getAttribute(RequestParameterName.REQ_PARAM_PASS )!= null) {
////                chain.doFilter(req,resp);
////        } else if(login != null && password != null){
////            ServiceProvider provider = ServiceProvider.getInstance();
////            UserService userService = provider.getUserService();
////            session.setAttribute(RequestParameterName.REQ_PARAM_LOGIN , userService);
////            session.setAttribute(RequestParameterName.REQ_PARAM_PASS , password);
////            req.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP).forward(req,resp);
////        }else{
////            req.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP).forward(req,resp);
////        }
//    }
//
//
//
//    @Override
//    public void destroy() {
//
//    }
//}
