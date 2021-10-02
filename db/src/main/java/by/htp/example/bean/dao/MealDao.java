package by.htp.example.bean.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealDao {

	ArrayList<Meal> getMealsFromDB() throws DaoException;

	Meal createMealInDB(Meal meal) throws DaoException;

	Meal changeMealCharacteristicInDB(Meal meal) throws DaoException;

	Meal deleteMealFromDB(Meal meal) throws DaoException;

	Meal getMealByIdFromDB(Meal meal) throws DaoException;

	Meal getMealByDateFromDB(Meal meal) throws DaoException;

}
