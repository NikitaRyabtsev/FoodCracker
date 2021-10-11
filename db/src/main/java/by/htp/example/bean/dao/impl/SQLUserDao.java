package by.htp.example.bean.dao.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.Role;
import by.htp.example.bean.dao.connection.DriverManagerManager;
import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.UserDao;

import java.sql.*;

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
}
