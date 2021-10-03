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
import java.security.Provider;

public class DeleteMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        MealService mealService = provider.getServiceMeal();
        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        int id = Integer.parseInt(idS);
        Meal meal = new Meal(id);
        Meal meal2;

        try{
            meal2 = mealService.deleteMeal(meal);
            request.setAttribute(RequestParameterName.REQ_PARAM_DELETE_MEAL,meal2);
            RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.DELETE_MEAL);
            dispatcher.forward(request,response);
        }catch(ServiceException e){
            e.printStackTrace();
        }
//        int userChoose;
//        ArrayList<Meal> meals;
//        try {
//            meals = provider.getServiceMeal().getMeals();
//            System.out.println("Input number of Meal u want to delete : ");
//            if (meals != null && !meals.isEmpty()) {
//                for (int i = 0; i < meals.size(); i++) {
//                    System.out.println("Meal  " + meals.get(i).getDate() + " " + meals.get(i).getTime());
//                }
//                userChoose = Util.scanInt();
//                displayMeals(meals);
//                provider.getServiceMeal().deleteMeal(meals.get(userChoose));
//                System.out.println("-----Meal was deleted-----");
//
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(">>>[Info] Meal is not exist");
//        } catch (ServiceException e1) {
//            System.out.println(">>>[Error]Somethin wrong in method deleteMeal()]");
//        }
    }
}
