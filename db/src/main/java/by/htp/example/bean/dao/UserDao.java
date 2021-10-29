package by.htp.example.bean.dao;

import by.htp.example.bean.user.User;
import by.htp.example.bean.user.UserWeightInfo;

import java.time.LocalDate;
import java.util.List;

public interface UserDao {

    User authorization(String login, String password) throws DaoException;

    void registration(String login,String password,String name, String secondName,
                      String email,String sex,LocalDate dateOfBirth,String role,String block) throws DaoException;

    User deleteUserFromDB(User user) throws DaoException;

    void blockUserInDB(User user) throws DaoException;

    List<User> getAllUsersFromDB() throws DaoException;

	User getEditAdminProfileInfo(int id) throws DaoException;

	User getEditUserAccessInfo(int id) throws DaoException;

    User EditProfileInDB(String login , String password , String name, String secondName
            ,String email,String sex , LocalDate dateOfBirth , int id) throws DaoException;

    void addUserWeightInDB(int id , double weight,LocalDate date) throws DaoException;

    List<UserWeightInfo> getWeightFromDB(int id) throws DaoException;



}
