package by.htp.example.command.impl;

import by.htp.example.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMealByIdCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
