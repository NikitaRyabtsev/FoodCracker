package by.htp.example.bean.dao;

public interface DaoQuery {
//Meals
	String SQL_QUERY_CREATE_MEAL = "INSERT INTO Meal (date,time,weight,calories) VALUES (?,?,?,?)";
	String SQL_QUERY_GET_MEAL = "SELECT * FROM Meal WHERE idMeal=?";
	String SQL_QUERY_GET_DATE = "SELECT * FROM Meal WHERE date=?";
	String SQL_QUERY_GET_ALL_MEAL = "SELECT * FROM Meal";
	String SQL_QUERY_DELETE_MEAL = "DELETE FROM Meal WHERE idMeal=?";
	String SQL_QUERY_CHANGE_MEAL = "UPDATE Meal SET date=? , time=? ,weight=? , calories=? WHERE idMeal=?";
//User
	String SQL_QUERY_USER_LOG_ON = "SELECT name ,role,block FROM User WHERE login=? AND password=?";
	String SQL_QUERY_USER_REGISTRATION = "INSERT INTO User (login,password,name,secondName,email,sex,weight,dateOfBirth) VALUES(?,?,?,?,?,?,?,?)";

	String SQL_QUERY_DELETE_USER = "DELETE FROM User WHERE idUser=?";
	String SQL_QUERY_GET_ALL_USERS = "SELECT * FROM User";
	String SQL_QUERY_BLOCK_USER = "UPDATE User SET block=? WHERE idUser=?";
	String SQL_QUERY_GET_USER_ACCESS_INFO = "SELECT login,password,name,secondName, email,sex,weight,dateOfBirth FROM User WHERE idUser=?";
	String SQL_QUERY_GET_ADMIN_ACCESS_INFO = "SELECT * FROM User WHERE idUser=?";


}
