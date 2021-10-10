package by.htp.example.bean.dao.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.connection.DriverManagerManager;
import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.UserDao;

import java.sql.*;

public class SQLUserDao implements UserDao, DaoQuery {


    @Override
    public User authorization(String login, String password) throws DaoException {
        User user = null;
        String role;
        String name;
        String rsLogin;
        String rsPassword;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_USER_LOG_ON)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            rsPassword = rs.getString("password");
            role = rs.getString("role");
            name = rs.getString("name");
            rsLogin = rs.getString("login");

            user = new User(rsLogin, rsPassword, name, role);
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
            prepareStatement.setDouble(5, user.getWeight());
            prepareStatement.setString(6, user.getRole());
            prepareStatement.setString(7, user.getEmail());
            prepareStatement.setString(8, user.getSex());
            prepareStatement.setObject(9, user.getDateOfBirth());

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
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_CHANGE_MEAL)) {

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
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
