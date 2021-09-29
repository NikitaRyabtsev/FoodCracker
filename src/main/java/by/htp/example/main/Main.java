package by.htp.example.main;

import java.sql.SQLException;

import by.htp.example.controller.MealController;
import by.htp.example.controller.impl.MealControllerImpl;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		MealController menu = new MealControllerImpl();
		menu.viewMenu();

		System.out.println("END");

	}

}
