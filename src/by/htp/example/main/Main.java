package by.htp.example.main;

import java.text.ParseException;
import java.util.Date;

import by.htp.example.fabric.Eating;
import by.htp.example.fabric.impl.EatingFactory;
import by.htp.example.param.TypeOfEating;

public class Main {

	public static void main(String[] args)throws ParseException{
		
		EatingFactory eatingFactory = new EatingFactory();
		
		Eating eating = eatingFactory.getEating(TypeOfEating.EATING);
	

	}

}
