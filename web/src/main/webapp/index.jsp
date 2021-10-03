<%@ page import="by.htp.example.bean.user.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MainPage</title>
</head>
<body>
<h1>Hello , bro</h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="authorization"/>
    <input type="text" name="login" value=""/>
    <input type="password" name="pass" value=""/>
    <input type="submit" value="Sign in"/><br/>
</form>

</body>
</html>
