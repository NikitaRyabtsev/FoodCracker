package by.htp.example.dao;

public interface DaoQuery {

	static final String SQL_QUERY_CREATE_MEAL = "INSERT INTO Meal (idMeal,date,time,weight,calories) VALUES (?,?,?,?,?)";
	static final String SQL_QUERY_GET_MEAL = "SELECT * FROM Meal WHERE idMeal=?";
	static final String SQL_QUERY_GET_DATE = "SELECT * FROM Meal WHERE date=?";
	static final String SQL_QUERY_GET_ALL_MEAL = "SELECT * FROM Meal";
	static final String SQL_QUERY_DELETE_MEAL = "DELETE FROM Meal WHERE idMeal=?";
	static final String SQL_QUERY_CHANGE_MEAL = "UPDATE Meal SET date=? , time=? ,weight=? , calories=? WHERE idMeal=?";

}
