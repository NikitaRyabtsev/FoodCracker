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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Админ</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<a href="#" class="nav-link px-2 text-secondary">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="get_all_users"/>
        <input type="submit" class="btn btn-success " value="Просмотреть пользователей"/>
    </form>
</a>
<table class="table table-striped table-hover">
    <tr>
        <td>Id</td>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>E-mail</td>
        <td>Пол</td>
        <td>Вес</td>
        <td>Дата взвешивания</td>
        <td>Дата Рождения</td>
        <td>Уровень доступа</td>
        <td>Статус</td>
    <tr>
         <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.password}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.secondName}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.sex}"/></td>
        <td><c:out value="${info.weight}"/></td>
        <td><c:out value="${info.dateOfWeighting}"/></td>
        <td><c:out value="${user.dateOfBirth}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td><c:out value="${user.block}"/></td>
    </tr>
</table>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add_user_weight"/>
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="date" name="date" value=""/>
    <input type="number" name="weight" value="">
    <td><input type="submit" value="Добавить вес"/></td>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="get_weight"/>
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="hidden" name="date">
    <td><input type="submit" value="Статистика веса"/></td>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
