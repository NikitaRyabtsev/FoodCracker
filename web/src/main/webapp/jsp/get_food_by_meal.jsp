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
    <link rel="icon" href="images/FoodCracker.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Пища</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="row" style=" text-align: center">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="change_meal"/>
        <input type="hidden" name="id" value="${param.keyMealId}">
        <div style="margin-left: 44%">
            <input type="date" class="w-25 form-control" name="date" value="${param.date}"/>
            <input type="time" class="w-25 form-control" name="time" value="${param.time}"/>
        </div>
            <br/>
            <input type="submit" class="btn btn-success" value="Изменить"/>
    </form>

</div>
</table>
<table class="w-100 table table-striped table-hover">
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
</div>
<form action="controller" method="post">
    <input type="hidden" name="command" value="to_product"/>
    <input type="hidden" name="keyMealId" value="${param.keyMealId}">
    <input type="submit" value="Добавить продукт">
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
