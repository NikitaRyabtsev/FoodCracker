package by.htp.example.bean.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.MealDao;
import by.htp.example.bean.dao.connection.DriverManagerManager;

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
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
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
                    throw new DaoException("Creating Meal failed, no ID obtained.");
                }
            }
            return meal;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Meal changeMealCharacteristicInDB(Meal meal) throws DaoException {

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_CHANGE_MEAL)) {

            prepareStatement.setObject(1, meal.getDate());
            prepareStatement.setObject(2, meal.getTime());
            prepareStatement.setDouble(3, meal.getWeight());
            prepareStatement.setDouble(4, meal.getWeight());
            prepareStatement.setInt(5, meal.getId());

            prepareStatement.executeUpdate();
            return meal;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Meal deleteMealFromDB(Meal meal) throws DaoException {

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_MEAL)) {
            preparedStatement.setInt(1, meal.getId());
            preparedStatement.executeUpdate();

            return meal;
        } catch (SQLException e) {
            throw new DaoException(e);
        }


    }

    @Override
    public Meal getMealByIdFromDB(Meal meal) throws DaoException {
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_MEAL)) {

            prepareStatement.setInt(1, meal.getId());
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return meal;

    }

    @Override
    public Meal getMealByDateFromDB(Meal meal) throws DaoException {
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_DATE)) {

            prepareStatement.setObject(1, meal.getDate());
            prepareStatement.executeUpdate();


        } catch (SQLException e) {

            throw new DaoException(e);
        }

        return meal;

    }

    private Meal init(ResultSet resultSet) throws DaoException {

        Meal meal = new Meal();
        try {
            meal.setId(resultSet.getInt("idMeal"));
            meal.setWeight(resultSet.getDouble("weight"));
            LocalDate localDate = resultSet.getObject("date", LocalDate.class);
            LocalTime localTime = resultSet.getObject("time", LocalTime.class);
            meal.setDate(localDate);
            meal.setTime(localTime);
            meal.setCalories(resultSet.getDouble("calories"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return meal;

    }

}
