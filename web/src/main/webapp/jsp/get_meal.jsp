<%@ page import="by.htp.example.bean.Meal" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="change_meal"/>
    <input type="submit" value="changeMeal"/>
    <input type="number" name = id value="">
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="number" name="weight" value=""/>
    <input type="number" name="calories" value=""/>
</form>
<table class="w-50 table table-striped table-hover">

    <tr>
        <td>Date</td>
        <td>Time</td>
        <td>Weight</td>
        <td>Calories</td>

    </tr>

    <tr>
        <c:forEach items="${requestScope.getMealByDate}" var="meal">
        <td><c:out value="${meal.getDate()}"/></td>
        <td><c:out value="${meal.getTime()}"/></td>
        <td><c:out value="${meal.getWeight()}"/></td>
        <td><c:out value="${meal.getCalories()}"/></td>
    </tr>
    </c:forEach>

</table>
<table class="w-50 table table-striped table-hover">
    <tr>
        <td>Название</td>
        <td>Калории</td>
        <td>Белки</td>
        <td>Жиры</td>
        <td>Углеводы</td>
    </tr>
    <tr>
        <c:forEach items="${requestScope.getFoodByMeal}" var="food">
        <td><c:out value="${food.getName()}"/></td>
        <td><c:out value="${food.getCalories()}"/></td>
        <td><c:out value="${food.getProteins()}"/></td>
        <td><c:out value="${food.getFats()}"/></td>
        <td><c:out value="${food.getCarbohydrates()}"/></td>
    </tr>
    </c:forEach>
</table>

</body>
<jsp:include page="/jsp/footer.jsp"/>
</html>
