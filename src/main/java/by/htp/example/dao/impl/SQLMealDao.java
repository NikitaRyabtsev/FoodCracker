package by.htp.example.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import by.htp.example.bean.Meal;
import by.htp.example.dao.DaoException;
import by.htp.example.dao.DaoQuery;
import by.htp.example.dao.MealDao;
import by.htp.example.dao.connection.DriverManagerManager;

public class SQLMealDao implements MealDao, DaoQuery {

	@Override
	public ArrayList<Meal> getMealsFromDB() throws DaoException {

		ArrayList<Meal> meals = new ArrayList<>();
		try {
			Connection connection = DriverManagerManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_QUERY_GET_ALL_MEAL);
			while (resultSet.next()) {
				meals.add(init(resultSet));

			}
		} catch (SQLException e) {
			throw new DaoException();
		}
		return meals;

	}

	@Override
	public Meal createMealInDB(Meal meal) throws DaoException {
		try (Connection connection = DriverManagerManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_CREATE_MEAL,
						Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setInt(1, meal.getId());
			preparedStatement.setObject(2, meal.getDate());
			preparedStatement.setObject(3, meal.getTime());
			preparedStatement.setDouble(4, meal.getWeight());
			preparedStatement.setDouble(5, meal.getCalories());

			preparedStatement.executeUpdate();

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					meal.setId(generatedKeys.getInt(1));
					meal.setDate(generatedKeys.getObject(2, LocalDate.class));
					meal.setTime(generatedKeys.getObject(3, LocalTime.class));
					meal.setWeight(generatedKeys.getDouble(4));
					meal.setCalories(generatedKeys.getDouble(5));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			return meal;

		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	public ArrayList<Meal> changeMealCharacteristicInDB(ArrayList<Meal> meals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Meal> deleteMealFromDB(ArrayList<Meal> meals) {
		// TODO Auto-generated method stub
		return null;
	}

	private Meal init(ResultSet resultSet) throws SQLException {

		Meal meal = new Meal();
		meal.setId(resultSet.getInt("idMeal"));
		meal.setWeight(resultSet.getDouble("weight"));
		LocalDate localDate = resultSet.getObject("date", LocalDate.class);
		LocalTime localTime = resultSet.getObject("time", LocalTime.class);
		meal.setDate(localDate);
		meal.setTime(localTime);
		meal.setCalories(resultSet.getDouble("calories"));
		return meal;
	}

	@Override
	public Meal getMealByIdFromDB(int id) throws DaoException {
		try (Connection connection = DriverManagerManager.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_MEAL)) {

			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return null;

	}

	@Override
	public Meal getMealByDateFromDB(LocalDate localDate) throws DaoException {
		try (Connection connection = DriverManagerManager.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_DATE)) {

			prepareStatement.setObject(1, localDate);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {

			throw new DaoException(e);
		}

		return null;

	}

}
