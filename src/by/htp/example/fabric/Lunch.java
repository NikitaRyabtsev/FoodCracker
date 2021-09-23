package by.htp.example.fabric;

import by.htp.example.param.EatingParameters;
import by.htp.example.param.Show;
import by.htp.example.param.TypeOfEating;

public class Lunch implements Eating{

	@Override
	public void addEating() {
		
		System.out.println("Lunch is ready");
		TypeOfEating.TIME_TO_EAT.set(2021, 9, 23, 13, 30);
		EatingParameters.CALORIES = "250";
		EatingParameters.WEIGTH_OF_EATING = "500g";
		Show.showParam();
	}

}
