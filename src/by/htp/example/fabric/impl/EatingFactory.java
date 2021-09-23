package by.htp.example.fabric.impl;

import java.util.Scanner;

import by.htp.example.fabric.AfternoonTea;
import by.htp.example.fabric.Breakfast;
import by.htp.example.fabric.Dinner;
import by.htp.example.fabric.Eating;
import by.htp.example.fabric.Lunch;
import by.htp.example.fabric.SecondBreakfast;
import by.htp.example.param.TypeOfEating;

public class EatingFactory {

	private Eating eating;
	
	public Eating getEating(String eatingParameters) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello , pls choose eating : Breakfast ,"
				+ " Lunch , Dinner , AfternoonTea , SecondBreakfast or Exit");
		TypeOfEating.EATING = in.nextLine();
		
		switch(TypeOfEating.EATING) {
		
		case "AfternoonTea" :
			
			eating = new AfternoonTea();
			eating.addEating();
			break;
		
		case "SecondBreakfast" :
			
			eating = new SecondBreakfast();
			eating.addEating();
			break;
		case "Breakfast":
			
			eating = new Breakfast();
			eating.addEating();
			break;
		case "Lunch":
			
			eating = new Lunch();
			eating.addEating();
			break;
		case "Dinner":
			
			eating = new Dinner();
			eating.addEating();
			break;
		case "Exit" :
			System.out.println("I'am on diet");
			break;
		
		default:
			throw new IllegalArgumentException("Wrong eating : " + TypeOfEating.EATING);
		}
		
		return eating;
		
	}
}
