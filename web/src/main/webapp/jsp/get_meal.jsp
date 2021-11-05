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
    <input type="number" name=id value="">
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="number" name="weight" value=""/>
    <input type="number" name="calories" value=""/>
</form>
<table class="w-100 table table-striped table-hover">

    <tr>
        <td>Дата</td>
        <td>Время</td>
        <td>Вес</td>
        <td>Калории</td>
    </tr>
    <c:forEach items="${requestScope.getMealByDate}" var="meal">
        <tr>
            <td><c:out value="${meal.getDate()}"/></td>
            <td><c:out value="${meal.getTime()}"/></td>
            <td><c:out value="${meal.getWeight()}"/></td>
            <td><c:out value="${meal.getCalories()}"/></td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="get_food_by_meal"/>
                    <input type="hidden" name="keyUserId" value="${user.id}"/>
                    <input type="hidden" name="keyMealId" value="${meal.getId()}">
                    <input type="hidden" name="date" value="${meal.getDate()}"/>
                    <input type="hidden" name="time" value="${meal.getTime()}">
                    <input type="hidden" value="${food.id}">
                    <input type="submit" value="Просмотреть">
                </form>
            </td>
            <td>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="delete_meal"/>
                    <input type="hidden" name="idMeal" value="${meal.getId()}"/>
                    <input type="hidden" name="id" value="${meal.id}">
                    <input type="submit" value="" class="btn-close"/>
                </form>
            </td>

        </tr>

    </c:forEach>
</table>
</body>
<jsp:include page="/jsp/footer.jsp"/>
</html>
