<%@ page import="by.htp.example.bean.Meal" %>
<%@ page import="java.util.List" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>All meals</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<h3>List of Meals : </h3>
<table class="table table-striped table-hover">

    <tr>
        <td>Date</td>
        <td>Time</td>
        <td>Weight</td>
        <td>Calories</td>
    </tr>

    <tr>
        <c:forEach items="${requestScope.getMeals}" var="meal" varStatus="status">
        <td><c:out value="${meal.getDate()}"/></td>
        <td><c:out value="${meal.getTime()}"/></td>
        <td><c:out value="${meal.getWeight()}"/></td>
        <td><c:out value="${meal.getCalories()}"/></td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="get_meal_by_id"/>
                <input type="hidden" name="id" value="${meal.getId()}"/>
                <td><input type="submit" value="Просмотреть"/></td>
            </form>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="delete_meal"/>
            <input type="hidden" name="id" value="${meal.getId()}"/>
            <td><input type="submit" value="" class="btn-close"/></td>
        </form>

    </tr>
    </c:forEach>

</table>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add_new_meal"/>

    <div class="col-md-4">
        <label for="validationDefault1" class="form-label">Дата</label>
        <input type="date" name="date" class="form-control" id="validationDefault1" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault2" class="form-label">Время</label>
        <input type="time" name="time" class="form-control" id="validationDefault2" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault3" class="form-label">Вес</label>
        <input type="number" name="weight" class="form-control" id="validationDefault3" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault4" class="form-label">Вес</label>
        <input type="number" name="calories" class="form-control" id="validationDefault4" value="" required>
    </div>
    <div class="col-md-3">
    <input type="submit" value="addMeal" class="btn btn-success"/>
    </div>
</form>
<button type="button" name="back" onclick="history.back()">back</button>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
