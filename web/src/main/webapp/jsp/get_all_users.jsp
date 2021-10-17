<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 12.10.2021
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Users</title>
</head>
<body>
<h1>HELLO</h1>
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
        <td>Дата Рождения</td>
        <td>Уровень доступа</td>
        <td>Статус</td>

    <tr>
        <c:forEach items="${requestScope.getUsers}" var="user" varStatus="status">
        <td><c:out value="${user.getId()}"/></td>
        <td><c:out value="${user.getLogin()}"/></td>
        <td><c:out value="${user.getPassword()}"/></td>
        <td><c:out value="${user.getName()}"/></td>
        <td><c:out value="${user.getSecondName()}"/></td>
        <td><c:out value="${user.getEmail()}"/></td>
        <td><c:out value="${user.getSex()}"/></td>
        <td><c:out value="${user.getWeight()}"/></td>
        <td><c:out value="${user.getDateOfBirth()}"/></td>
        <td><c:out value="${user.getRole()}"/></td>
        <td><c:out value="${user.getBlock()}"/></td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="block_user"/>
               <td><input type="hidden" name="id" value="${user.getId()}"></td>
                <td><select class="form-control" name="blockUser" >
                    <option>block</option>
                    <option>unblock</option>
                </select></td>
                <td><input type="submit" value=""class="form-control"></td>
            </form>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="delete_user"/>
                <input type="hidden" name="id" value="${user.getId()}"/>
                <td><input type="submit" value="" class="btn-close"></td>
            </form>
    </tr>
    </c:forEach>

</table>
</body>
</html>
