package by.htp.example.bean.dao;

import by.htp.example.bean.user.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDao {

    User authorization(String login, String password) throws DaoException;

    void registration(User user) throws DaoException;

    User deleteUserFromDB(User user) throws DaoException;

    void blockUserInDB(User user) throws DaoException;

    List<User> getAllUsersFromDB() throws DaoException;

	User getEditAdminAccessInfo(int id , int weightId) throws DaoException;

	User getEditUserAccessInfo(int id , int weightId) throws DaoException;

    User EditProfileInDB(String login , String password , String name, String secondName
            ,String email,String sex , LocalDate dateOfBirth , int id) throws DaoException;

    User addUserWeightInDB(int id , double weight,LocalDate date) throws DaoException;

    List<User>  getWeightFromDB(int id) throws DaoException;


}
