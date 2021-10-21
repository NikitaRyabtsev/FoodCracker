package by.htp.example.main;


import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import java.util.Properties;

public class Main {

    private static final String URL = "http://localhost:8080/rest/meal";

    public static void main(String[] args) throws NamingException {
		ejbBeans();


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



    }

    public static void rest(){

	}
}
