package by.htp.example.fabric;

import by.htp.example.param.EatingParameters;
import by.htp.example.param.Show;
import by.htp.example.param.TypeOfEating;

public class SecondBreakfast implements Eating{

	@Override
	public void addEating() {
		
		System.out.println("SecondBreakfast");
		TypeOfEating.TIME_TO_EAT.set(2021, 9, 23, 11, 00);
		EatingParameters.CALORIES = "20";
		EatingParameters.WEIGTH_OF_EATING = "50g";
		Show.showParam();
	}

}
