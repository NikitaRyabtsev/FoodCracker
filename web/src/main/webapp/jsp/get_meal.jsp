<%@ page import="by.htp.example.bean.Meal" %><%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 03.10.2021
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<h1>Get Meal</h1>
<%
    Meal meal;
    meal = (Meal)request.getAttribute("getMeal");
    out.println(meal.getWeight());
    int i = 10;
    int b = 10;
    out.println(i+b);
%>

</body>
</html>
