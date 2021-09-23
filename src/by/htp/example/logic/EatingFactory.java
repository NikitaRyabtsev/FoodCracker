package by.htp.example.logic;

import java.util.Scanner;

import by.htp.example.bean.Breakfast;
import by.htp.example.bean.Dinner;
import by.htp.example.bean.Lunch;

public class EatingFactory {

	private Eating eating;
	
	public Eating getEating(String eatingParameters) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello , pls choose eating : Breakfast , Lunch , Dinner : ");
		EatingParameters.EATING = in.nextLine();
	
		switch(EatingParameters.EATING) {
		
		case "Breakfast":
			
			eating = new Breakfast();
			break;
		
		case "Lunch":
			
			eating = new Lunch();
			break;
			
		case "Dinner":
			
			eating = new Dinner();
			break;
		
		default:
			throw new IllegalArgumentException("Wrong eating : " + EatingParameters.EATING);
		}
		
		return eating;
		
	}
}
