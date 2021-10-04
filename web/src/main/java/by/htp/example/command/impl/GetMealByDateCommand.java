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
import java.time.LocalDate;

public class GetMealByDateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServiceProvider provider = ServiceProvider.getInstance();
        String dateS = request.getParameter(RequestParameterName.REQ_PARAM_DATE);

        LocalDate date = LocalDate.parse(dateS);


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
