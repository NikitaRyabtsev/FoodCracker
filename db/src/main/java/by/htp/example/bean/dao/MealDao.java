package by.htp.example.bean.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.example.bean.Meal;

public interface MealDao {

	ArrayList<Meal> getMealsFromDB(int keyUserId) throws DaoException;

	Meal createMealInDB(Meal meal) throws DaoException;

	void changeMealCharacteristicInDB(Meal meal) throws DaoException;

	Meal deleteMealFromDB(Meal meal) throws DaoException;

	Meal getMealByIdFromDB(int idMeal) throws DaoException;

	List<Meal> getMealByDateFromDB(LocalDate date) throws DaoException;

}
