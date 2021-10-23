package by.htp.example.bean.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public ArrayList<Meal> getMealsFromDB(int keyUserId) throws DaoException {
        ArrayList<Meal> meals = new ArrayList<>();
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_MEAL)) {

            preparedStatement.setInt(1, keyUserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                meals.add(init(resultSet));
            }
            resultSet.close();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return meals;

    }

    @Override
    public Meal createMealInDB(LocalDate date, LocalTime time, int keyUserId) throws DaoException {
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_CREATE_MEAL)) {
            Meal meal = new Meal();
            preparedStatement.setObject(1, date);
            preparedStatement.setObject(2, time);
            preparedStatement.setInt(3, keyUserId);

            preparedStatement.executeUpdate();

            return meal;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Meal changeMealCharacteristicInDB(LocalDate date ,
                               LocalTime time,int mealId) throws DaoException {
        Meal meal;
        int id = 0;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_CHANGE_MEAL)) {
            prepareStatement.setObject(1, date);
            prepareStatement.setObject(2, time);
            prepareStatement.setInt(3, mealId);
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idMeal");
            }
            meal = new Meal(id,date,time);
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return meal;
    }

    @Override
    public void deleteMealFromDB(int id) throws DaoException {
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_MEAL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Meal getMealByIdFromDB(int mealId) throws DaoException {
        Meal meal = new Meal();
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_MEAL)) {
            prepareStatement.setInt(1, mealId);
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {

                meal.setWeight(rs.getDouble("weight"));
                LocalDate localDate = rs.getObject("date", LocalDate.class);
                LocalTime localTime = rs.getObject("time", LocalTime.class);
                meal.setDate(localDate);
                meal.setTime(localTime);
                meal.setCalories(rs.getDouble("calories"));
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
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_DATE)) {
            prepareStatement.setObject(1, date);
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                meal = init(rs);
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
            meal.setKeyUserId(resultSet.getInt("user_idUser"));
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
