package by.htp.example.bean.dao.impl;

import by.htp.example.bean.Food;
import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.FoodDao;
import by.htp.example.bean.dao.connection.DriverManagerManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SQLFoodDao implements FoodDao, DaoQuery {
    @Override
    public List<Food> getAllFoodFromDB() throws DaoException {
        List<Food> foods = new ArrayList<>();
        try {
            Connection connection = DriverManagerManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_QUERY_GET_ALL_FOOD);
            while (resultSet.next()) {
                foods.add(init(resultSet));
            }
            resultSet.close();
            statement.close();
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
