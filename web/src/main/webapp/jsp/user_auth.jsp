<%@ page import="by.htp.example.bean.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Hello , User</h1>
<h2>Choose your option : </h2>

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_all_meals"/>
    <input type="submit" value="getMeals"/><br/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add_new_meal"/>
    <input type="submit" value="addMeal">
    <input type="number" name="id" value=""/>
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="text" name="weight" value=""/>
    <input type="text" name="calories" value=""/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="get_meal_by_id"/>
    <input type="submit" value="getMeal"/>
    <input type ="text" name="id" value=""/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_meal"/>
    <input type="submit" value="deleteMeal"/>
    <input type = "number" name = "id" value=""/>
</form>
</body>
</html>
