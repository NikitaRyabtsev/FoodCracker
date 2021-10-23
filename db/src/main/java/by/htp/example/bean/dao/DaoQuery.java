package by.htp.example.bean.dao;

public interface DaoQuery {
//Meals
	String SQL_QUERY_CREATE_MEAL = "INSERT INTO Meal (date,time,user_idUser) VALUES (?,?,?)";
	String SQL_QUERY_GET_MEAL = "SELECT date, time, weight,SUM(food.calories) AS calories FROM Meal m" +
			"LEFT JOIN food_has_meal fhm ON idMeal = fhm.meal_idMeal " +
			"LEFT JOIN food ON fhm.food_idFood = food.idFood " +
			"WHERE idMeal = ?";
	String SQL_QUERY_GET_DATE = "SELECT * FROM Meal WHERE date=?";

	String SQL_QUERY_DELETE_MEAL = "DELETE Meal from Meal WHERE idMeal = ?";

	String SQL_QUERY_CHANGE_MEAL = "UPDATE Meal SET date=?,time=? WHERE idMeal=?";

	String SQL_QUERY_GET_ALL_MEAL =
			"SELECT idMeal,weight,user_idUser, date ,time,SUM(food.calories) AS calories " +
			" FROM meal " +
			" LEFT JOIN food_has_meal on meal.idMeal = food_has_meal.meal_idMeal " +
			" LEFT JOIN Food ON food_has_meal.food_idFood = food.idFood " +
			" WHERE user_idUser = ? " +
			" GROUP BY meal.idMeal,meal.date,meal.time";


//User
	String SQL_QUERY_USER_LOG_ON = "SELECT * FROM User WHERE login=? AND password=?";
	String SQL_QUERY_USER_REGISTRATION = "INSERT INTO User (login,password,name,secondName,email,sex,weight,dateOfBirth,role,block) VALUES(?,?,?,?,?,?,?,?,?,?) ";

	String SQL_QUERY_DELETE_USER = "DELETE FROM User WHERE idUser=?";
	String SQL_QUERY_GET_ALL_USERS = "SELECT * FROM User";
	String SQL_QUERY_BLOCK_USER = "UPDATE User SET block=? WHERE idUser=?";
	String SQL_QUERY_GET_USER_ACCESS_INFO = "SELECT login,password,name,secondName, email,sex,weight,dateOfBirth FROM User WHERE idUser=?";
	String SQL_QUERY_GET_ADMIN_ACCESS_INFO = "SELECT * FROM User WHERE idUser=?";
	String SQL_QUERY_ADD_WEIGHT = "INSERT INTO user_weight (user_idUser,weight,date) values (?,?,?)";
	String SQL_QUERY_EDIT_PROFILE = "UPDATE User SET login =? , password=? , name=?,secondName=? , email=?,sex=? , dateOfBirth=? WHERE idUser = ?";
//Food
	String SQL_QUERY_GET_ALL_FOOD = "SELECT * FROM Food";
	String SQL_QUERY_GET_FOOD_BY_MEAL = "SELECT food.* FROM meal JOIN food_has_meal ON meal.idMeal = food_has_meal.meal_idMeal " +
			" JOIN Food ON food_has_meal.food_IdFood = food.IdFood " +
			" WHERE meal.idMeal = ? AND user_idUser = ?";
	String SQL_QUERY_ADD_FOOD_IN_MEAL = "INSERT INTO food_has_meal (meal_idMeal,food_idFood) VALUES (?,?)";

}
