package by.htp.example.fabric;


import by.htp.example.param.EatingParameters;
import by.htp.example.param.Show;
import by.htp.example.param.TypeOfEating;

public class AfternoonTea implements Eating{

	@Override
	public void addEating() {
		
		System.out.println("AfternoonTea");
		TypeOfEating.TIME_TO_EAT.set(2021, 9, 23, 17, 30);
		EatingParameters.CALORIES = "50";
		EatingParameters.WEIGTH_OF_EATING = "50g";
		Show.showParam();

}
}