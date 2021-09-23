package by.htp.example.fabric;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import by.htp.example.param.EatingParameters;
import by.htp.example.param.Show;
import by.htp.example.param.TypeOfEating;

public class NewEating implements Eating{


	@Override
	public void addEating() throws ParseException{
		System.out.println("Input Date like:hh:mm dd.MM.yy");
		
		Scanner scan = new Scanner(System.in);
		
		TypeOfEating.EATING = scan.nextLine();
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm dd.MM.yy");		
		
		Date date = dateFormat.parse(TypeOfEating.EATING);	
		TypeOfEating.TIME_TO_EAT.setTime(date);
		System.out.println(date);
		
		System.out.println("Input Calories : ");
		EatingParameters.CALORIES = scan.next();
		
		System.out.println("Input WeigthOfFood in gramms : ");
		EatingParameters.WEIGTH_OF_EATING = scan.next();
		
		Show.showParam();
		
		
	}

	
}
