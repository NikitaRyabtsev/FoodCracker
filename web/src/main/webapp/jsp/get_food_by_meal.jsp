<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 18.10.2021
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Пища</title>

</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<table class="table table-striped table-hover">
    <tr>
        <td>Название</td>
        <td>Калории</td>
        <td>Белки</td>
        <td>Жиры</td>
        <td>Углеводы</td>
    </tr>
    <c:forEach items="${requestScope.getFoodByMeal}" var="food">
    <tr>
        <td><c:out value="${food.getName()}"/></td>
        <td><c:out value="${food.getCalories()}"/></td>
        <td><c:out value="${food.getProteins()}"/></td>
        <td><c:out value="${food.getFats()}"/></td>
        <td><c:out value="${food.getCarbohydrates()}"/></td>
    </tr>
    </c:forEach>
</table>

<form action="controller" method="post">
    <input type="hidden" name="command" value="add_food_in_meal"/>
    <input name="keyFoodId" value="<%=request.getParameter("keyMealId")%>"/>
    <input value="<%=request.getParameter("keyMealId")%>"/>
    <input hidden value="${param.keyMealId}"/>
    <input type="submit" value="Добавить"/>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
