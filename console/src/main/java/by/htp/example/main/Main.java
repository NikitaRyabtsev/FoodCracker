package by.htp.example.main;


import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.view.ViewMenuEjb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final String URL = "http://localhost:8080/rest/meal";

    public static void main(String[] args) throws NamingException {
		ejbBeans();
       // rest();

    }

    public static void ejbBeans() throws NamingException {
        Properties p = new Properties();
        p.setProperty("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
        p.setProperty("java.naming.provider.url", "remote+http://localhost:8080");
        p.setProperty("java.naming.security.principal", "jndiuser");
        p.setProperty("java.naming.security.credentials", "jndiuser");

        System.out.println("creating context");
        InitialContext ctx = new InitialContext(p);

        System.out.println("checking on remote");
        MealServiceRemote mealServiceRemote = (MealServiceRemote) ctx.lookup("web-1.0-SNAPSHOT/MealServiceImpl!by.htp.example.MealServiceRemote");
      try {
          System.out.println(mealServiceRemote.getMeals("1"));
          ViewMenuEjb viewMenuEjb = new ViewMenuEjb();
          viewMenuEjb.viewMenu();
      }catch(ServiceException e){
          e.printStackTrace();
          e.getMessage();
      }

    }

    public static void rest(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);

        Meal meal = new Meal();

        Response responseAdd = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(meal, MediaType.APPLICATION_JSON));


        Response responseGet = target.request(MediaType.APPLICATION_JSON).get();
        GenericType<List<Meal>> type = new GenericType<List<Meal>>() {};
        List<Meal> meals = responseGet.readEntity(type);

        client.close();

    }
}
