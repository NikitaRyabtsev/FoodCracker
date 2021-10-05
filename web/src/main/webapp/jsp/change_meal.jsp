<%@ page import="by.htp.example.bean.Meal" %><%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 04.10.2021
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Meal meal;
    meal = (Meal) request.getAttribute("changeMeal");
    out.println(meal + " gdgd");

%>
</body>
</html>
