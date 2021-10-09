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

        	preparedStatement.setString(1,login);
        	preparedStatement.setString(2,password);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();

			rsPassword = rs.getString("password");
			role = rs.getString("role");
			name = rs.getString("name");
			rsLogin = rs.getString("login");

			user = new User(rsLogin,rsPassword,name,role);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return user;
    }

    @Override
    public void registration(User user) throws DaoException {

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_USER_REGISTRATION)) {
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(8, user.getSex());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setDouble(5, user.getWeight());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setObject(9, user.getDateOfBirth());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
