package by.htp.example.fabric;


import by.htp.example.param.EatingParameters;
import by.htp.example.param.TypeOfEating;

public class Dinner implements Eating{

	@Override
	public void addEating() {
		
		System.out.println("Dinner is ready");
		TypeOfEating.TIME_TO_EAT.set(2021, 9, 23, 20, 00);
		EatingParameters.CALORIES = "100";
		EatingParameters.WEIGTH_OF_EATING = "100g";
		System.out.println(TypeOfEating.TIME_TO_EAT.getTime());
	}

}