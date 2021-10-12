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
           if(rs.next()) {
               rsPassword = rs.getString("password");
               rsLogin = rs.getString("login");
               name = rs.getString("name");
               user = new User(rsLogin, rsPassword, name);
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
    public User blockUserInDB(int id) throws DaoException {
        User user = null;
        int idUser = 0;
        boolean block = false;
        try (Connection connection = DriverManagerManager.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(SQL_QUERY_BLOCK_USER)) {
            prepareStatement.setObject(1, idUser);
            prepareStatement.setBoolean(11,block);
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()) {

                id = rs.getInt("idUser");
                boolean blockDB = rs.getBoolean("block");
                String login =  rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                double weight = rs.getDouble("weight");
                LocalDate dateOfBirth = rs.getObject("date", LocalDate.class);
                user = new User(id,blockDB);
            }

        }catch(SQLException e){
            throw new DaoException(e);
        }
        return user;

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
            prepareStatement.setObject(1, idUser);

            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()) {
                id = rs.getInt("idUser");
                String login =  rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                double weight = rs.getDouble("weight");
                LocalDate dateOfBirth = rs.getObject("date", LocalDate.class);

                user = new User(id,login,password,email,name,secondName,weight,sex,dateOfBirth);
            }

        }catch(SQLException e){
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
            prepareStatement.setObject(1, idUser);

            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()) {
                id = rs.getInt("idUser");
                String login =  rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                double weight = rs.getDouble("weight");
                LocalDate dateOfBirth = rs.getObject("date", LocalDate.class);
                Role role = (Role) rs.getObject("role");
                boolean block = rs.getBoolean("block");

                user = new User(id,login,password,email,name,secondName,weight,sex,dateOfBirth,role,block);
            }

        }catch(SQLException e){
            throw new DaoException(e);
        }
        return user;
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
