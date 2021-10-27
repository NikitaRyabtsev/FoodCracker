package by.htp.example.view;

import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.impl.MealServiceImpl;
import by.htp.example.util.Util;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ViewMenuRest {
    private static final String URL = "http://localhost:8080/ws/rest/meal";


    public void viewRest() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);
        Meal meal = new Meal();
        GenericType<Meal> mealGenericType = new GenericType<Meal>() {
        };
        GenericType<List<Meal>> type = new GenericType<List<Meal>>() {
        };
        int userChoose = 0;
        while (userChoose != 7) {
            try {
                showMenu();
                userChoose = Util.scanInt();

                switch (userChoose) {
                    case 1:
                        Response responseGet = target.request(MediaType.APPLICATION_JSON).get();
                        List<Meal> meals = responseGet.readEntity(type);
                        displayMeals(meals);
                        break;
                    case 2:
                        Response responseAdd;
                        responseAdd = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(meal, MediaType.APPLICATION_JSON));
                        meal = responseAdd.readEntity(mealGenericType);
                        break;
                    case 3:
                        Response responseChange;
                        responseChange = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(meal, MediaType.APPLICATION_JSON));
                       meal = responseChange.readEntity(mealGenericType);
                        break;
                    case 4:
                        Response responseDelete = target.request(MediaType.APPLICATION_JSON).delete();
                        meal = responseDelete.readEntity(mealGenericType);
                        break;
                    case 5:
                        Response responseById = target.request(MediaType.APPLICATION_JSON).get();
                        meal = responseById.readEntity(mealGenericType);
                        break;
                    case 6:
                        Response responseByDate = target.request(MediaType.APPLICATION_JSON).get();
                        meals = responseByDate.readEntity(type);
                        displayMeals(meals);
                        break;
                    case 7:
                        System.out.println("Goodbye");
                        break;

                    default:
                        System.out.println(">>>[Info] Wrong choose");
                }
            } catch (InputMismatchException | DateTimeException | IllegalArgumentException ex) {
                ex.getMessage();
            }
            client.close();

        }
    }

    private void displayMeals(List<Meal> meals) {

        if (meals != null && !meals.isEmpty()) {
            for (int i = 0; i < meals.size(); i++) {
                System.out.println(
                        "#" + meals.get(i).getId() + " Meals Date: " + meals.get(i).getDate() + " Time: " + meals.get(i).getTime());
            }
        }
    }

    private void showMenu() {
        System.out.println("Choose your options : ");
        System.out.println("1. Просмотерть все приёмы пищи");
        System.out.println("2. Добавить приём пищи");
        System.out.println("3. Изменить приём пищи");
        System.out.println("4. Удалить приём пищи");
        System.out.println("5. Выбрать приём пищи по номеру");
        System.out.println("6. Выбрать приём пищи по дате");
        System.out.println("7. Exit");
    }
}


