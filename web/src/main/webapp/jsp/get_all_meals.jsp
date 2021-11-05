<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="icon" href="images/FoodCracker.ico">
    <link rel="shortcut icon" href="#"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Все приёмы пищи</title>

</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div style="margin-left: 36%">
    <h3>Добавить приём пищи</h3>
    <form action="controller" method="post" class="text-center">
        <input type="hidden" name="command" value="add_new_meal"/>

        <div class="col-md-4">
            <label for="validationDefault" class="form-label">Дата</label>
            <input type="date" name="date" class="form-control" id="validationDefaul" value="" required>
        </div>
        <div class="col-md-4">
            <label for="validationDefault" class="form-label">Время</label>
            <input type="time" name="time" class="form-control" id="validationDefault" value="" required>
        </div>
        <div>
            <input type="hidden" name="id" value="${user.id}" required>
        </div>
        <div class="col-md-4">
            <input type="submit" value="Добавить" class="btn btn-success"/>
        </div>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="get_meal_by_date"/>
        <input type="submit" class="btn btn-success " value="Приёмы пищи"/>
        <input type="date" name="date" id="validationDefault03" value=""/>
    </form>
</div>

<table class="table table-striped table-hover">
    <tr>
        <td>Дата</td>
        <td>Время</td>
        <td>Вес(г)</td>
        <td>Калории</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${requestScope.getMeals}" var="meal" varStatus="status">
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
                    <input type="hidden" name="id" value="${meal.getId()}">
                    <input type="submit" value="" class="btn-close"/>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>
<table class="table table-striped table-hover">
    <c:forEach items="${requestScope.getMealByDate}" var="meal" varStatus="status">
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
                    <input type="hidden" name="id" value="${meal.getId()}">
                    <input type="submit" value="" class="btn-close"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
