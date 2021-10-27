package by.htp.example.bean.dao;

public interface DaoQuery {
    //Meals
    String SQL_QUERY_CREATE_MEAL = "INSERT INTO Meal (date,time,user_idUser) VALUES (?,?,?)";

    String SQL_QUERY_GET_MEAL = "SELECT date, time, SUM(portion) AS weight ,SUM(food.calories) AS calories FROM Meal m" +
            "LEFT JOIN food_has_meal fhm ON idMeal = fhm.meal_idMeal " +
            "LEFT JOIN food ON fhm.food_idFood = food.idFood " +
            "WHERE idMeal = ?";

    String SQL_QUERY_GET_MEAL_BY_DATE = "SELECT * FROM Meal WHERE date=?";

    String SQL_QUERY_DELETE_MEAL = "DELETE Meal from Meal WHERE idMeal = ?";

    String SQL_QUERY_CHANGE_MEAL = "UPDATE Meal SET date=?,time=? WHERE idMeal=?";

    String SQL_QUERY_GET_ALL_MEAL =
            "SELECT idMeal,SUM(portion) AS weight,user_idUser, date ,time,SUM(food.calories) AS calories \n" +
                    "FROM meal " +
                    "LEFT JOIN food_has_meal on meal.idMeal = food_has_meal.meal_idMeal  " +
                    "LEFT JOIN Food ON food_has_meal.food_idFood = food.idFood  " +
                    "WHERE user_idUser = ? " +
                    "GROUP BY meal.idMeal,meal.date,meal.time" +
                    " ORDER by date DESC";


    //User
    String SQL_QUERY_USER_LOG_ON = "SELECT user.* ,user_idUser FROM User JOIN user_weight " +
            "  ON idUser = user_idUser WHERE login=? AND password=?";
    String SQL_QUERY_USER_REGISTRATION = "INSERT INTO User (login,password,name,secondName,email,sex,dateOfBirth,role,block) VALUES(?,?,?,?,?,?,?,?,?) ";

    String SQL_QUERY_DELETE_USER = "DELETE FROM User WHERE idUser=?";
    //
    String SQL_QUERY_GET_ALL_USERS = "SELECT user.* ,user_weight.weight AS weight, MAX(date) AS date FROM User  " +
            "JOIN user_weight ON idUser = user_weight.user_idUser ";

    String SQL_QUERY_BLOCK_USER = "UPDATE User SET block=? WHERE idUser=?";

    String SQL_QUERY_GET_USER_ACCESS_INFO = "SELECT login,password,name,secondName, email,sex,dateOfBirth, " +
            "  weight, date ,user_idUser" +
            " FROM User " +
            " JOIN user_weight " +
            " ON idUser = user_weight.user_idUser AND date = (select max(date) from user_weight WHERE user_idUser = idUser) " +
            " WHERE idUser= ?";

    String SQL_QUERY_GET_ADMIN_ACCESS_INFO = "SELECT user.* ,user_weight.weight AS weight, user_idUser , " +
            " date FROM User JOIN user_weight " +
            " ON idUser = user_idUser AND date = (select max(date) from user_weight WHERE user_idUser = idUser)  " +
            " WHERE idUser = ?";

    String SQL_QUERY_ADD_WEIGHT = "INSERT INTO user_weight (user_idUser,weight,date) values (?,?,?)";

    String SQL_QUERY_GET_USER_WEIGHT = "SELECT user_weight.weight AS us_weight , user_weight.date AS date FROM user " +
            "JOIN user_weight ON idUser = user_weight.user_idUser " +
            "WHERE idUser = ? " +
            "ORDER BY user_weight.date DESC";

    String SQL_QUERY_EDIT_PROFILE = "UPDATE User SET login =? , password=? , name=?,secondName=? , email=?,sex=? , dateOfBirth=? WHERE idUser = ?";

    //Food
    String SQL_QUERY_GET_ALL_FOOD = "SELECT * FROM Food";
    String SQL_QUERY_GET_FOOD_BY_MEAL = "SELECT food.* FROM meal JOIN food_has_meal ON meal.idMeal = food_has_meal.meal_idMeal " +
            " JOIN Food ON food_has_meal.food_IdFood = food.IdFood " +
            " WHERE meal.idMeal = ? AND user_idUser = ?";
    String SQL_QUERY_ADD_FOOD_IN_MEAL = "INSERT INTO food_has_meal (meal_idMeal,food_idFood) VALUES (?,?)";

}
