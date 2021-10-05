<%@ page import="by.htp.example.bean.Meal" %>

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
<jsp:include page="user_auth.jsp"/>

</body>
</html>
