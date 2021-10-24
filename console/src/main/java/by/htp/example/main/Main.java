package by.htp.example.main;


import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.view.ViewMenu;
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


    public static void main(String[] args){
		ViewMenu viewMenu = new ViewMenu();
		viewMenu.viewMenu();

    }

}
