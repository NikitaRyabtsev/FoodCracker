package by.htp.example.bean.dao.impl;

import by.htp.example.bean.dao.UserDao;
import by.htp.example.bean.user.User;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.connection.DriverManagerManager;
import by.htp.example.bean.dao.DaoQuery;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDao, DaoQuery {

    @Override
    public User authorization(String login, String password) throws DaoException {
        User user = null;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_USER_LOG_ON)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = init(rs);
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

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_BLOCK_USER)) {

            preparedStatement.setString(1, user.getBlock());
            preparedStatement.setInt(2,user.getId());
            preparedStatement.executeUpdate();

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
    public User EditProfileInDB(String login , String password , String name, String secondName
    ,String email,String sex , LocalDate dateOfBirth , int id) throws DaoException {

        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_EDIT_PROFILE)) {
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, password);
            prepareStatement.setString(3, name);
            prepareStatement.setString(4, secondName);
            prepareStatement.setString(5,email);
            prepareStatement.setString(6, sex);
            prepareStatement.setObject(7, dateOfBirth);
            prepareStatement.setInt(8,id);

            prepareStatement.executeUpdate();
        }catch(SQLException e){
            throw new DaoException(e);
        }

            return null;
    }

    @Override
    public User addUserWeightInDB(int id , double weight,LocalDate date) throws DaoException {
        User user = new User();
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_ADD_WEIGHT)) {
            prepareStatement.setInt(1, id);
            prepareStatement.setDouble(2,weight);
            prepareStatement.setObject(3,date);

            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    return user;
    }

    @Override
    public User getEditAdminAccessInfo(int id) throws DaoException {
        User user = null;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_GET_ADMIN_ACCESS_INFO)) {
            prepareStatement.setInt(1, id);

            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                user = init(rs);
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
