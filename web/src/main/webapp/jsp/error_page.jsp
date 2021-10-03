<%@ page import="by.htp.example.bean.Meal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    ERROR<br>
    <form action="controller" method="post">
        <input type="hidden" name="command" value=""/>
        <input type="submit" value="back">
            <%
    Meal meal;
    meal = (Meal) request.getAttribute("incorrect");
    out.println("ERROR");
%>

</body>
</html>
