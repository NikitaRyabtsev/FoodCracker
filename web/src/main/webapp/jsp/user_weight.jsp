<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href=/style.css"/>
    <title>Page Title</title>
</head>
<body>

<table class="table table-striped table-hover">
    <tr>
        <td>Дата</td>
        <td>Вес(г)</td>
    </tr>

        <c:forEach items="${requestScope.getUserWeight}" var="weight" varStatus="status">
    <tr>
            <td><c:out value="${weight.getDateOfWeighting()}"/></td>
            <td><c:out value="${weight.getWeight()}"/></td>
    </tr>
        </c:forEach>
</table>
</body>
</html>