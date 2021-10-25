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
    private static final String URL = "http://localhost:8080/rest/meal";

    public void rest() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);
        Meal meal = new Meal();
        Response responseAdd = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(meal, MediaType.APPLICATION_JSON));
        Response responseGet = target.request(MediaType.APPLICATION_JSON).get();
        GenericType<List<Meal>> type = new GenericType<List<Meal>>() {
        };
        List<Meal> meals = responseGet.readEntity(type);

        client.close();
    }

}
