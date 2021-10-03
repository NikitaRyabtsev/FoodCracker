package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;
import by.htp.example.service.UserService;
import by.htp.example.service.impl.MealServiceImpl;
import by.htp.example.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddNewMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        int id = 0;
        LocalDate date = null;
        LocalTime time = null;
        double weight = 0;
        double calories = 0;
        Meal meal;
        try {

            System.out.println("Input id of meal");
            id = Util.scanInt();
            date = Util.scanDate();
            time = Util.scanTime();
            System.out.println("Input weight");
            weight = Util.scanDouble();
            System.out.println("Input calories");
            calories = Util.scanDouble();

        } catch (DateTimeException e) {
            System.out.println("[Info] Wrong Date");
        }
        meal = new Meal(id, date, time, weight, calories);
        MealService mealService = provider.getServiceMeal();
        try{
            meal = mealService.createMeal(meal);
            request.setAttribute(RequestParameterName.REQ_PARAM_ADD_MEAL,meal);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
//        tring login = request.getParameter(RequestParameterName.REQ_PARAM_LOGIN);
//        String password = request.getParameter(RequestParameterName.REQ_PARAM_PASS);
//
//        UserService userService = provider.getUserService();
//        User user;
//        try {
//            user = userService.authorization(login, password);
//            request.setAttribute(RequestParameterName.REQ_PARAM_USER, user);
//            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.USER_AUTH_PAGE_JSP);
//            dispatcher.forward(request, response);
        }
    }
