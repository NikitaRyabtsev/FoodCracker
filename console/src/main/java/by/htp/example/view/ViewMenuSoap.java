package by.htp.example.view;

import by.htp.example.soap.ServiceException_Exception;
import by.htp.example.soap.SoapMealService;
import by.htp.example.soap.Ws_002fMeal;

public class ViewMenuSoap {

    public void viewSoap() throws ServiceException_Exception {

    Ws_002fMeal mealsWSFactory = new Ws_002fMeal();
    SoapMealService mealWS = mealsWSFactory.getSoapMealServicePort();
    System.out.println(mealWS.getMeals("4"));
}
}
