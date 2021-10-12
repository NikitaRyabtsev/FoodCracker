package by.htp.example.bean.dao.impl;

import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.Role;
import by.htp.example.bean.dao.connection.DriverManagerManager;
import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.UserDao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDao, DaoQuery {


    @Override
    public User authorization(String login, String password) throws DaoException {
        User user = null;
        String name;
        String rsLogin;
        String rsPassword;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_USER_LOG_ON)) {

            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println(1);
            rsPassword = rs.getString("password");
            rsLogin = rs.getString("login");
            name = rs.getString("name");
            System.out.println(2);
            user = new User(rsLogin, rsPassword, name);
            System.out.println(3);
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return user;
    }

    @Override
    public void registration(User user) throws DaoException {

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_USER_REGISTRATION)) {

            prepareStatement.setString(1, user.getLogin());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getName());
            prepareStatement.setString(4, user.getSecondName());
            prepareStatement.setString(5, user.getEmail());
            prepareStatement.setString(6, user.getSex());
            prepareStatement.setDouble(7, user.getWeight());
            prepareStatement.setObject(8, user.getDateOfBirth());

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User deleteUserFromDB(User user) throws DaoException {
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_DELETE_USER)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();

            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void editProfileInDB(User user) throws DaoException {
        int id;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_EDIT_PROFILE)) {

            prepareStatement.setString(1, user.getLogin());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getName());
            prepareStatement.setString(4, user.getSecondName());
            prepareStatement.setDouble(5, user.getWeight());
            prepareStatement.setString(6, user.getEmail());
            prepareStatement.setString(7, user.getSex());
            prepareStatement.setObject(8, user.getDateOfBirth());

            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.executeQuery();
            rs.next();
            id = rs.getInt("idUser");
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean blockUserInDB(int id) throws DaoException {
        
        return false;
    }

    @Override
    public List<User> getAllUsersFromDB() throws DaoException {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DriverManagerManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_QUERY_GET_ALL_USERS);
            while (resultSet.next()) {
                users.add(init(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return users;
    }

    private User init(ResultSet rs)throws DaoException{
        User user = new User();
        try {
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSecondName(rs.getString("secondName"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setWeight(rs.getDouble("weight"));
            LocalDate localDate = rs.getObject("date", LocalDate.class);
            user.setRole((Role) rs.getObject("role"));
            user.setBlock(rs.getBoolean("block"));

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }
}
