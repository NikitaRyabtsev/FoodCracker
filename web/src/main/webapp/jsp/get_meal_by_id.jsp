<%@ page import="by.htp.example.bean.Meal" %>
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
    out.println(meal);

    int i = 10;
    int b = 10;
    out.println(i+b);
%>
</body>
</html>
