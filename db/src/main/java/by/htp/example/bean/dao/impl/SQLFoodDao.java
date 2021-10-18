package by.htp.example.bean.dao.impl;

import by.htp.example.bean.Food;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.FoodDao;
import by.htp.example.bean.dao.connection.DriverManagerManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLFoodDao implements FoodDao, DaoQuery {
    @Override
    public List<Food> getAllFoodFromDB() throws DaoException {
        List<Food> foods = new ArrayList<>();

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_FOOD)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foods.add(init(resultSet));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return foods;
    }

    @Override
    public List<Food> getFoodByMeal(int keyMealId, int keyUserId) throws DaoException {
        List<Food> foods = new ArrayList<>();

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_FOOD_BY_MEAL)) {

            Food food = new Food();
            preparedStatement.setInt(1, keyMealId);
            preparedStatement.setInt(2, keyUserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                foods.add(food);
                foods.add(init(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return foods;

    }



    private Food init(ResultSet resultSet) throws DaoException {

        Food food = new Food();
        try {
            food.setId(resultSet.getInt("idFood"));
            food.setName(resultSet.getString("name"));
            food.setCalories(resultSet.getDouble("calories"));
            food.setProteins(resultSet.getDouble("proteins"));
            food.setFats(resultSet.getDouble("fats"));
            food.setCarbohydrates(resultSet.getDouble("carbohydrates"));

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return food;

    }
}
