<%@ page import="by.htp.example.bean.Meal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<h1>GetMeal</h1>
<%
    Meal meal;
    meal = (Meal)request.getAttribute("getMealById");
    meal = (Meal)request.getAttribute("getMealByDate");
    out.println(meal + " get meal ");
%>


</body>
</html>
