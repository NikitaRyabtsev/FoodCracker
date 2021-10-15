package by.htp.example.bean.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_CREATE_MEAL)) {

            preparedStatement.setObject(1, meal.getDate());
            preparedStatement.setObject(2, meal.getTime());
            preparedStatement.setDouble(3, meal.getWeight());
            preparedStatement.setDouble(4, meal.getCalories());

            preparedStatement.executeUpdate();

            return meal;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void changeMealCharacteristicInDB(Meal meal) throws DaoException {
        int id;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_CHANGE_MEAL)) {

            prepareStatement.setObject(1, meal.getDate());
            prepareStatement.setObject(2, meal.getTime());
            prepareStatement.setDouble(3, meal.getWeight());
            prepareStatement.setDouble(4, meal.getCalories());
            prepareStatement.setInt(5, meal.getId());

            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idMeal");
            }
            rs.close();
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
    public Meal getMealByIdFromDB(int idMeal) throws DaoException {
        Meal meal = null;
        int id;
        LocalDate date;
        LocalTime time;
        double weight;
        double calories;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_MEAL)) {

            prepareStatement.setInt(1, idMeal);

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idMeal");
                date = rs.getObject("date", LocalDate.class);
                time = rs.getObject("time", LocalTime.class);
                calories = rs.getDouble("calories");
                weight = rs.getDouble("weight");

                meal = new Meal(id, date, time, weight, calories);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }


        return meal;

    }

    @Override
    public List<Meal> getMealByDateFromDB(LocalDate date) throws DaoException {
        List<Meal> meals = new ArrayList<>();
        Meal meal = null;
        int id;
        LocalTime time;
        LocalDate rsDate;
        double weight;
        double calories;

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_DATE)) {
            prepareStatement.setObject(1, date);
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()) {
                id = rs.getInt("idMeal");
                rsDate = rs.getObject("date", LocalDate.class);
                time = rs.getObject("time", LocalTime.class);
                calories = rs.getDouble("calories");
                weight = rs.getDouble("weight");

                meal = new Meal(id, rsDate, time, calories, weight);
                meals.add(meal);
            }
            rs.close();
        } catch (SQLException e) {

            throw new DaoException(e);
        }

        return meals;

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
