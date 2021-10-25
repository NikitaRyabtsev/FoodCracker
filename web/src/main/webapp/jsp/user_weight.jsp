<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вес</title>
</head>
<body>
<tr>
<tr>
    <td>Вес</td>
    <td>Дата</td>
</tr>
<c:forEach items="${requestScope.getUserWeight}" var="user" varStatus="status">
<td><c:out value="${user.weight}"/></td>
<td><c:out value="${user.date}"/></td>
</c:forEach>
</tr>
</body>
</html>