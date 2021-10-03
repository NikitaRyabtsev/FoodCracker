<%@ page import="by.htp.example.bean.Meal" %><%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 03.10.2021
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteMeal</title>
</head>
<body>
<%
    Meal meal;
    meal = (Meal) request.getAttribute("deleteMeal");
    out.println("Meal was deleted");
%>
</body>
</html>
