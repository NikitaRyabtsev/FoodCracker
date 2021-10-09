package by.htp.example.filter;

//import by.htp.example.bean.dao.DaoException;
//import by.htp.example.bean.user.User;
//import by.htp.example.command.JSPPageName;
//import by.htp.example.command.RequestParameterName;
//import by.htp.example.service.MealService;
//import by.htp.example.service.ServiceException;
//import by.htp.example.service.ServiceProvider;
//import by.htp.example.service.UserService;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//public class UserFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        ServiceProvider provider = ServiceProvider.getInstance();
//        User user = null;
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        HttpSession session = req.getSession(false);
//        if (session == null) {
//            session = req.getSession(true);
//        }
//        try {
//            String url = req.getRequestURI();
//            String login = req.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
//            String password = req.getParameter(RequestParameterName.REQ_PARAM_PASS);
//
//            if (session.getAttribute(RequestParameterName.REQ_PARAM_LOGIN) != null
//                    && session.getAttribute(RequestParameterName.REQ_PARAM_PASS) != null) {
//
//                chain.doFilter(req, resp);
//
//            } else if (login != null && password != null) {
//
//                user = provider.getUserService().authorization(login, password);
//                session.setAttribute(RequestParameterName.REQ_PARAM_USER, user);
//                req.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP).forward(req, resp);
//            }
////            } else {
////                if (url.equals(JSPPageName.USER_AUTH_PAGE_JSP)) {
////                    chain.doFilter(req, resp);
////                } else if (url.equals(JSPPageName.USER_REGISTRATION)) {
////
////                    String email = req.getParameter(RequestParameterName.REQ_PARAM_EMAIL);
////                    String name = req.getParameter(RequestParameterName.REQ_PARAM_NAME);
////                    String secondName = req.getParameter(RequestParameterName.REQ_PARAM_SECOND_NAME);
////                    String weightS = req.getParameter(RequestParameterName.REQ_PARAM_WEIGHT);
////                    String sex = req.getParameter(RequestParameterName.REQ_PARAM_SEX);
////                    String dateOfBirthS = req.getParameter(RequestParameterName.REQ_PARAM_DATE_OF_BIRTH);
////                    String role = req.getParameter(RequestParameterName.REQ_PARAM_ROLE);
////
////                    double weight = Integer.parseInt(weightS);
////                    LocalDate dateOfBirth = LocalDate.parse(dateOfBirthS);
////                    user = new User(login, password, email, name, secondName, weight, sex, dateOfBirth, role);
////                    provider.getUserService().registration(user);
////                    req.getRequestDispatcher(JSPPageName.USER_REGISTRATION).forward(req, resp);
////                } else {
////
////                }
////            }
//        } catch (ServiceException | DaoException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
