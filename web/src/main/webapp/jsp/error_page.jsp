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
    out.println("Wrong chose , try again");
%>
<jsp:include page="user_auth.jsp"/>
</body>
</html>
