package by.htp.example.bean.dao.impl;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.connection.DriverManagerManager;
import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoQuery;
import by.htp.example.bean.dao.UserDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDao, DaoQuery {


    @Override
    public User authorization(String login, String password) throws DaoException {
        User user = null;
        String name;
        String role;
        String block;
        int id;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_USER_LOG_ON)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                name = rs.getString("name");
                role = rs.getString("role");
                id = rs.getInt("idUser");
                block = rs.getString("block");

                user = new User(role, name, id, block);
            }
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
            prepareStatement.setString(9, user.getRole());
            prepareStatement.setString(10, user.getBlock());

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
    public void blockUserInDB(User user) throws DaoException {
        int id;
        String block;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_BLOCK_USER)) {
            prepareStatement.setInt(1, user.getId());
            prepareStatement.setString(2, user.getBlock());
        } catch (SQLException e) {
            throw new DaoException(e);
        }


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

    @Override
    public User getEditUserAccessInfo(int id) throws DaoException {
        User user = null;
        int idUser = 0;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_USER_ACCESS_INFO)) {
            prepareStatement.setInt(1, idUser);

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idUser");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                double weight = rs.getDouble("weight");
                LocalDate dateOfBirth = rs.getObject("dateOfBirth", LocalDate.class);

                user = new User(id, login, password, email, name, secondName, weight, sex, dateOfBirth);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public User getEditAdminAccessInfo(int id) throws DaoException {
        User user = null;
        int idUser = 0;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_ADMIN_ACCESS_INFO)) {
            prepareStatement.setInt(1, idUser);

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {

                id = rs.getInt("idUser");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                double weight = rs.getDouble("weight");
                LocalDate dateOfBirth = rs.getObject("dateOfBirth", LocalDate.class);
                String role = rs.getString("role");
                String block = rs.getString("block");

                user = new User(id, login, password, email, name, secondName, weight, sex, dateOfBirth, role, block);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    private User init(ResultSet rs) throws DaoException {
        User user = new User();
        try {
            user.setId(rs.getInt("idUser"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSecondName(rs.getString("secondName"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setWeight(rs.getDouble("weight"));
            LocalDate localDate = rs.getObject("dateOfBirth", LocalDate.class);
            user.setDateOfBirth(localDate);
            user.setRole(rs.getString("role"));
            user.setBlock(rs.getString("block"));

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }
}
