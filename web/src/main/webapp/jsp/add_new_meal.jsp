
<%@ page import="by.htp.example.bean.Meal" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new meal</title>
</head>
<body>
<%
    Meal meal;
    meal = (Meal) request.getAttribute("addMeal");
    out.println("Meal : " + meal);
  int i =10;
  int b = 20;
  int sum = i+b;
  out.println(sum);
%>
</body>
</html>
