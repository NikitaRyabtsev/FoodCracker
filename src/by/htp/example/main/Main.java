package by.htp.example.main;

import java.util.Date;

import by.htp.example.fabric.Eating;
import by.htp.example.fabric.impl.EatingFactory;
import by.htp.example.param.TypeOfEating;

public class Main {

	public static void main(String[] args) {
		
		EatingFactory eatingFactory = new EatingFactory();
		
		Eating eating = eatingFactory.getEating(TypeOfEating.EATING);
	

	}

}
