package by.htp.example.logic;

import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealService {

	void getMeals(ArrayList<Meal> meals);

	Meal createMeal();

	ArrayList<Meal> changeMealCharacteristic(ArrayList<Meal> meals);
	
	ArrayList<Meal> deleteMeal(ArrayList<Meal> meals);
}
