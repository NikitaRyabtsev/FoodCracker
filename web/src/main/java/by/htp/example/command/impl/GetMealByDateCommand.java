package by.htp.example.command.impl;

import by.htp.example.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMealByDateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        LocalDate userChoose;
//        try {
//            ArrayList<Meal> meals = provider.getServiceMeal().getMeals();
//            userChoose = Util.scanDate();
//            for (int i = 0; i < meals.size(); i++) {
//                if (userChoose.equals(meals.get(i).getDate())) {
//                    System.out.println("------------------------------------------");
//                    System.out.println(meals.get(i).toString());
//                    System.out.println("------------------------------------------");
//                }
//            }
//        } catch (DateTimeException ex) {
//            System.out.println(">>>[Info]Wrong parameters");
//        } catch (ServiceException e) {
//            System.out.println("[Error] Something wrong with metho getMealByDate()");
//        }
    }
}
