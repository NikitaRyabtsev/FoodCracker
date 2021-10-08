package by.htp.example.bean.dao;

public interface DaoQuery {

	String SQL_QUERY_CREATE_MEAL = "INSERT INTO Meal (date,time,weight,calories) VALUES (?,?,?,?)";
	String SQL_QUERY_GET_MEAL = "SELECT * FROM Meal WHERE idMeal=?";
	String SQL_QUERY_GET_DATE = "SELECT * FROM Meal WHERE date=?";
	String SQL_QUERY_GET_ALL_MEAL = "SELECT * FROM Meal";
	String SQL_QUERY_DELETE_MEAL = "DELETE FROM Meal WHERE idMeal=?";
	String SQL_QUERY_CHANGE_MEAL = "UPDATE Meal SET date=? , time=? ,weight=? , calories=? WHERE idMeal=?";

	String SQL_QUERY_USER_LOG_ON = "SELECT password,role,name FROM User WHERE login=?,password=?";
	String SQL_QUERY_USER_REGISTRATION = "INSERT INTO User (login,password,name,secondName,weight,role,email,sex,dateOfBirth) " +
			"VALUES(?,?,?,?,?,?,?,?,?)";



}
