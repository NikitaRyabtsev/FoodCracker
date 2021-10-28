package by.htp.example.bean.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.bean.Meal;

public interface MealDao {

	List<Meal> getMealsFromDB(int keyUserId) throws DaoException;

	Meal createMealInDB(LocalDate date, LocalTime time, int keyUserId) throws DaoException;

	Meal changeMealCharacteristicInDB(int mealId,LocalDate date ,
									  LocalTime time) throws DaoException;

	void deleteMealFromDB(int id) throws DaoException;

	Meal getMealByIdFromDB(int idMeal) throws DaoException;

	List<Meal> getMealByDateFromDB(LocalDate date) throws DaoException;

}
