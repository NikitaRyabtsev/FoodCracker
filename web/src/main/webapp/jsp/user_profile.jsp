<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 15.10.2021
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<h1>Hello,user</h1>
<table class="table table-striped table-hover">
    <tr>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>E-mail</td>
        <td>Пол</td>
        <td>Вес(кг)</td>
        <td>Дата Рождения</td>
        <td>Уровень доступа</td>

    <tr>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.password}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.secondName}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.sex}"/></td>
        <td><c:out value="${user.weight}"/></td>
        <td><c:out value="${user.dateOfBirth}"/></td>
        <td><c:out value="${user.role}"/></td>
    </tr>
</table>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add_user_weight"/>
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="date" name="date" value=""/>
    <input type="number" name="weight" value="">
    <td><input type="submit" value="Добавить вес"/></td>
</form>
<h3>Изменить профиль</h3>
<form action="controller" method="post">
    <input type="hidden" name="command" value="edit_profile"/>
    <div class="form-group col-md-6">
        <label for="validationDefault01">Логин</label>
        <input type="login" name="login" class="w-50 form-control" id="validationDefault01" placeholder="Введите логин"
               required>
    </div>
    <div class="form-group col-md-6">
        <label for="validationDefault02">Пароль</label>
        <input type="text" name="password" class="form-control" id="validationDefault02" placeholder="Пароль" required>
    </div>
    </div>
    <div class="form-group">
        <label for="validationDefault03">E-mail</label>
        <input type="email" name="email" class="form-control" id="validationDefault03" placeholder="email:vasya@vasya"
               required>
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
        <input type="date" name="dateOfBirth" class="form-control" id="validationDefault05" placeholder="Дата рождения"
               required>
    </div>
    <div class="form-group">
        <label for="validationDefault06">Имя</label>
        <input type="text" name="name" class="form-control" id="validationDefault06" placeholder="Имя" required>
    </div>
    <div class="form-group">
        <label for="validationDefault07">Фамилия</label>
        <input type="text" name="secondName" class="form-control" id="validationDefault07" placeholder="Фамилия"
               required>
    </div>
    <div class="form-group">
        <input type="hidden" name="id" value="${user.id}">
    </div>
    <div class="form-group">
        <label for="validationDefault08">Изменить</label>
        <input type="submit" class="form-control" id="validationDefault08"
               required>
    </div>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>