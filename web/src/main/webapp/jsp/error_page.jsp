<%@ page import="by.htp.example.bean.Meal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>

<%
    Meal meal;
    meal = (Meal) request.getAttribute("incorrect");
    out.println("ERROR" + meal);
%>

</body>
</html>
