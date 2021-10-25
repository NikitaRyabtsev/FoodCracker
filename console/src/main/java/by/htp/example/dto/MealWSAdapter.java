package by.htp.example.dto;

import by.htp.example.bean.Meal;

import java.time.LocalDate;
import java.time.LocalTime;

public class MealWSAdapter {

    public Meal transformMeal(by.htp.example.soap.Meal meal){
        return new Meal(meal.getMealId(), LocalDate.parse(meal.getDateOfEating()),
                LocalTime.parse(meal.getTimeOfEating()));
    }
}
