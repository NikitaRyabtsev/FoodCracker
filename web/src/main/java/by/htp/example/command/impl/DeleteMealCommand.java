package by.htp.example.command.impl;

import by.htp.example.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
