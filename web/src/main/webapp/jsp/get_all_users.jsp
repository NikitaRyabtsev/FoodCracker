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
<table class="table table-striped table-hover">

    <tr>
        <td>login</td>
        <td>password</td>
        <td>name</td>
        <td>secondName</td>
    </tr>

    <tr>
        <c:forEach items="${requestScope.getUsers}" var="user" varStatus="status">
        <td><c:out value="${user.getLogin()}"/></td>
        <td><c:out value="${user.getPassword()}"/></td>
        <td><c:out value="${user.getName()}"/></td>
        <td><c:out value="${user.getSecondName()}"/></td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
