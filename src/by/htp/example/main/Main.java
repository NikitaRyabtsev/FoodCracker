package by.htp.example.main;

import java.util.Date;

import by.htp.example.logic.Eating;
import by.htp.example.logic.EatingFactory;
import by.htp.example.logic.EatingParameters;

public class Main {

	public static void main(String[] args) {
		
		EatingFactory eatingFactory = new EatingFactory();
		
		Date date = new Date();
		
		Eating breakfast = eatingFactory.getEating(EatingParameters.BREAKFAST);

		Eating lunch = eatingFactory.getEating(EatingParameters.LUNCH);

		
		Eating dinner = eatingFactory.getEating(EatingParameters.DINNER);

		
		

	}

}
