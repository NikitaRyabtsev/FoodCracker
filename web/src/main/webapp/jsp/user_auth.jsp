<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
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
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="number" name="weight" value=""/>
    <input type="number" name="calories" value=""/>
</form>
</body>
</html>
