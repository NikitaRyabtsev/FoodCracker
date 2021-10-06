
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
    out.println("Meal was create");
%>
<jsp:include page="user_auth.jsp"/>
</body>
</html>
