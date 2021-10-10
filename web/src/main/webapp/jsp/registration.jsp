<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 08.10.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Registration</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="user_registration"/>
    <input type="login" name="login" value="">
    <input type="password" name="password" value="">
    <input type="email" name="email" value="">
    <input type="text" name="role" value="">
    <input type="text" name="sex" value="">
    <input type="text" name="name" value="">
    <input type="text" name="secondName" value="">
    <input type="number" name="weight" value="">
    <input type="submit" value="Зарегеситрироваться"/>
</form>
<form>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="w-50 form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword" placeholder="Пароль">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPasswor" placeholder="Пароль">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPasswo" placeholder="Пароль">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassw" placeholder="Пароль">
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
