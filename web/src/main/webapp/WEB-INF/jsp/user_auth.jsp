<%@ page import="by.htp.example.bean.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%
    User user;

    user = (User) request.getAttribute("user");
    out.print(user.getName());

%>
</body>
</html>
