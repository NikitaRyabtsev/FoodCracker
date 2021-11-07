<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 15.10.2021
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/FoodCracker.ico">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Продукты</title>
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
        <td>Порция(г)</td>
        <td></td>

    </tr>
    <c:forEach items="${requestScope.getFoods}" var="food" varStatus="status">
    <tr>
        <td><c:out value="${food.getName()}"/></td>
        <td><c:out value="${food.getCalories()}"/></td>
        <td><c:out value="${food.getProteins()}"/></td>
        <td><c:out value="${food.getFats()}"/></td>
        <td><c:out value="${food.getCarbohydrates()}"/></td>
        <td><c:out value="${food.getPortion()}"/></td>
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="add_food_in_meal"/>
                <input type="hidden" name="keyMealId" value="${param.keyMealId}"/>
                <input type="hidden" name="keyFoodId" value="${food.id}"/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
