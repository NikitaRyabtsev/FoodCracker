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
    <title>Регистрация</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="form-row">
<form action="controller" method="post">
    <input type="hidden" name="command" value="registration"/>
    <div class="row">
    <div class="form-group col-md-6">
        <label for="validationDefault01">Логин</label>
        <input type="login" name="login" class="w-50 form-control" id="validationDefault01" placeholder="Введите логин" required>
    </div>
    <div class="form-group col-md-6">
        <label for="validationDefault02">Пароль</label>
        <input type="text" name ="password" class="form-control" id="validationDefault02" placeholder="Пароль" required>
    </div>
    </div>
    <div class="form-group">
        <label for="validationDefault03">E-mail</label>
        <input type="email" name = "email" class="form-control" id="validationDefault03" placeholder="email:vasya@vasya" required>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Пол</label>
        <select class="form-control" name="sex" id="exampleFormControlSelect1">
            <option>male</option>
            <option>female</option>
        </select>
    </div>
    <div class="form-group col-md-4">
        <label for="validationDefault05">Дата рождения</label>
        <input type="date" name ="dateOfBirth" class="form-control" id="validationDefault05" placeholder="Дата рождения" required>
    </div>
    <div class="form-group">
        <label for="validationDefault06">Имя</label>
        <input type="text" name ="name" class="form-control" id="validationDefault06" placeholder="Имя" required>
    </div>
    <div class="form-group">
        <label for="validationDefault07">Фамилия</label>
        <input type="text" name ="secondName" class="form-control" id="validationDefault07" placeholder="Фамилия" required>
    </div>
    <div class="form-group">
        <input type="hidden" name = "blockUser" class="form-control"  value="unlock" required>
    </div>
    <div class="form-group">
        <input type="hidden" name = "role" class="form-control" value="user" required>
    </div>
    <div class="form-group">
        <label for="validationDefault08">Вес</label>
        <input type="number" name ="userWeight" class="form-control" id="validationDefault08" placeholder="Вес" required>
    </div>
    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    <jsp:include page="/jsp/footer.jsp"/>
</form>
</div>
</form>
</body>
</html>
