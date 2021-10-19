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
    <title>User</title>
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
        <td>Вес</td>
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
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>