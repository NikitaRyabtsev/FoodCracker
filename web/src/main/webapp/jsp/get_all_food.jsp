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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Food</title>
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
    <tr>
        <c:forEach items="${requestScope.getFoods}" var="food" varStatus="status">
        <td><c:out value="${food.getName()}"/></td>
        <td><c:out value="${food.getCalories()}"/></td>
        <td><c:out value="${food.getProteins()}"/></td>
        <td><c:out value="${food.getFats()}"/></td>
        <td><c:out value="${food.getCarbohydrates()}"/></td>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="get_food_by_meal"/>
                <input type="hidden" name="id" value="${user.id}"/>
                <input type="hidden" name="keyIdMeal" value="${meal.id}">
                <td><input type="submit" value="" class="btn-close"></td>
            </form>
    </tr>
    </c:forEach>

</table>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
