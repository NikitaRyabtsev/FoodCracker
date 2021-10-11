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
    <input type="hidden" name="command" value="registration"/>
    <div class="form-group">
        <label for="exampleLogin">Логин</label>
        <input type="login" name="login" class="w-50 form-control" id="exampleLogin" placeholder="Введите логин">
    </div>
    <div class="form-group">
        <label for="examplePassword">Пароль</label>
        <input type="text" name ="password" class="form-control" id="examplePassword" placeholder="Пароль">
    </div>
    <div class="form-group">
        <label for="exampleEmail">E-mail</label>
        <input type="email" name = "email" class="form-control" id="exampleEmail" placeholder="email:vasya@vasya">
    </div>
    <div class="form-group">
        <label for="exampleSex">Пол</label>
        <input type="text" name ="sex" class="form-control" id="exampleSex" placeholder="Пол">
    </div>
    <div class="form-group">
        <label for="exampleDateOfBirth">Дата рождения</label>
        <input type="date" name ="dateOfBirth" class="form-control" id="exampleDateOfBirth" placeholder="Дата рождения">
    </div>
    <div class="form-group">
        <label for="exampleName">Имя</label>
        <input type="text" name ="name" class="form-control" id="exampleName" placeholder="Имя">
    </div>
    <div class="form-group">
        <label for="exampleSecondName">Фамилия</label>
        <input type="text" name ="secondName" class="form-control" id="exampleSecondName" placeholder="Фамилия">
    </div>
    <div class="form-group">
        <label for="exampleWeight">Вес</label>
        <input type="number" name ="userWeight" class="form-control" id="exampleWeight" placeholder="Вес">
    </div>
    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    <jsp:include page="/jsp/footer.jsp"/>
</form>
</body>
</html>
