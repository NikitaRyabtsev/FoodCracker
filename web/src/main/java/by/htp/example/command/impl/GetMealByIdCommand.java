package by.htp.example.command.impl;

import by.htp.example.bean.Meal;
import by.htp.example.command.Command;
import by.htp.example.command.JSPPageName;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.MealService;
import by.htp.example.service.ServiceException;
import by.htp.example.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMealByIdCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);

        int id = Integer.parseInt(idS);

        MealService mealService = provider.getServiceMeal();
        Meal meal = new Meal(id);
        Meal meal2;
        try{
            meal2 = mealService.getMealById(meal);
            request.setAttribute(RequestParameterName.REQ_PARAM_GET_MEAL,meal2);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.GET_MEAL);
            dispatcher.forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        //        int userChoose = 0;
//        try {
//            ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
//            displayMeals(meals);
//            System.out.println("Input meal number : ");
//            userChoose = Util.scanInt();
//            if (userChoose < 1 || userChoose > meals.size()) {
//                throw new IllegalArgumentException();
//            }
//
//            System.out.println("------------------------------------------");
//
//            System.out.println(meals.get(userChoose).toString());
//
//            System.out.println("------------------------------------------");
//
//        } catch (IllegalArgumentException e) {
//            System.out.println(">>>[Info] Wrong choose , no such meal in the list");
//        } catch (ServiceException ex) {
//            System.out.println(">>>[Error] Error with method getMealById()");
//        }
    }
}
