package by.htp.example.main;

import by.htp.example.controller.MealController;
import by.htp.example.controller.impl.MealControllerImpl;

public class Main {

	public static void main(String[] args){

		MealController menu = new MealControllerImpl();
		menu.viewMenu();

		System.out.println("END");

	}

}
