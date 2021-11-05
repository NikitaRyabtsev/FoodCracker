package by.htp.example.impl.rest;

import by.htp.example.MealService;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MealRestServiceImpl implements MealService {
    private static final String URL = "http://localhost:8080/ws/rest/meal";

    @Override
    public List<Meal> getMeals(String keyUserId) throws ServiceException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);

        Response responseGet = target.request(MediaType.APPLICATION_JSON).get();
        GenericType<List<Meal>> type = new GenericType<List<Meal>>() {
        };
        List<Meal> meals = responseGet.readEntity(type);
        client.close();
        return meals;
    }

    @Override
    public Meal createMeal(String date, String time, String id) throws ServiceException {
        Client client = ClientBuilder.newClient();
        Meal meal = new Meal();
        WebTarget target = client.target(URL).path("/new");
        Response responseAdd;
        responseAdd = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(meal, MediaType.APPLICATION_JSON));
        Meal resultMeal = responseAdd.readEntity(Meal.class);

        client.close();
        return resultMeal;
    }

    @Override
    public Meal changeMealCharacteristic(String date, String time, String mealId) throws ServiceException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL).path("/" + mealId);
        Meal meal = new Meal();
        Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity(meal, MediaType.APPLICATION_JSON));
        Meal resultMeal = response.readEntity(Meal.class);

        client.close();

        return resultMeal;
    }

    @Override
    public void deleteMeal(String id) throws ServiceException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL).path("/" + id);

        target.request(MediaType.APPLICATION_JSON).delete();

        client.close();

    }

    @Override
    public Meal getMealById(String id) throws ServiceException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL).path("/" + id);

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        Meal meal = response.readEntity(Meal.class);

        client.close();

        return meal;
    }

    @Override
    public List<Meal> getMealByDate(String date) throws ServiceException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL).path("/" + date);
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        GenericType<List<Meal>> type = new GenericType<List<Meal>>() {
        };
        List<Meal> meals = response.readEntity(type);

        client.close();

        return meals;
    }
}
