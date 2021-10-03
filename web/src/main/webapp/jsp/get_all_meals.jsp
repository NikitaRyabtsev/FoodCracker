<%@ page import="by.htp.example.bean.Meal" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All meals</title>
</head>
<body>
<%
    List<Meal> meals;
    meals = (List<Meal>) request.getAttribute("getMeals");
    out.println(meals);
%>
</body>
</html>
