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


public class DeleteMealCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServiceProvider provider = ServiceProvider.getInstance();
        MealService mealService = provider.getServiceMeal();

        String idS = request.getParameter(RequestParameterName.REQ_PARAM_ID);
        int id = Integer.parseInt(idS);

        Meal meal = new Meal(id);
           try {
                mealService.deleteMeal(meal);
                request.setAttribute(RequestParameterName.REQ_PARAM_DELETE_MEAL, meal);
                RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPageName.DELETE_MEAL);
                dispatcher.forward(request, response);
            } catch (ServiceException e) {
                e.printStackTrace();

            }
        }

    }

