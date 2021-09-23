package by.htp.example.fabric;

import by.htp.example.param.EatingParameters;
import by.htp.example.param.Show;
import by.htp.example.param.TypeOfEating;


public class Breakfast implements Eating{
	@Override
	public void addEating() {

		System.out.println("Good Morning.Breakfast");
		TypeOfEating.TIME_TO_EAT.set(2021, 9, 23, 7, 30);
		EatingParameters.WEIGTH_OF_EATING = "300g";
		EatingParameters.CALORIES = "350";
		Show.showParam();
		
	}

}
