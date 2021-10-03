<%@ page import="by.htp.example.bean.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Hello , User</h1>
<h2>Choose your option : </h2>

<form action="controller" method="post">
    <input type="hidden" name="command" value="get_all_Meals"/>
    <input type="submit" value="getMeals"/><br/>
</form>
<h4>
    <%
        User user;
        user = (User) request.getAttribute("user");
        out.print(user.getName());
    %>
</h4>
</body>
</html>
