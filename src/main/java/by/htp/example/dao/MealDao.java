package by.htp.example.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import by.htp.example.bean.Meal;

public interface MealDao {

	ArrayList<Meal> getMealsFromDB() throws DaoException;

	Meal createMealInDB(Meal meal) throws DaoException;

	ArrayList<Meal> changeMealCharacteristicInDB(Meal meal) throws DaoException;

	ArrayList<Meal> deleteMealFromDB(Meal meal) throws DaoException;

	Meal getMealByIdFromDB(int id) throws DaoException;

	Meal getMealByDateFromDB(LocalDate localDate) throws DaoException;

}
