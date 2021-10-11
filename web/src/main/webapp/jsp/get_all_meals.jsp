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
    <input type="submit" value="addMeal">
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="number" name="weight" value=""/>
    <input type="number" name="calories" value=""/>
</form>
<button type="button" name="back" onclick="history.back()">back</button>

<form action="controller" method="post" class = "row g-3">
    <input type="hidden" name="command" value="registration"/>
    <div class="col-md-4">
        <label for="validationDefault01" class="form-label">Имя</label>
        <input type="text" name="name" class="form-control" id="validationDefault01" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault02" class="form-label">Фамилия</label>
        <input type="text" name="secondName" class="form-control" id="validationDefault02" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefaultUsername" class="form-label">E-mail</label>
        <div class="input-group">
            <span class="input-group-text" id="inputGroupPrepend2">@</span>
            <input type="text" name="email" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2" required>
        </div>
    </div>
    <div class="col-md-3">
        <label for="validationDefault07" class="form-label">Имя пользователя</label>
        <input type="text" name="login" class="form-control" id="validationDefault07" required>
    </div>
    <div class="col-md-3">
        <label for="validationDefault03" class="form-label">Пароль</label>
        <input type="text" name="password" class="form-control" id="validationDefault03" required>
    </div>
    <div class="col-md-3">
        <label for="validationDefault04" class="form-label">Пол</label>
        <select class="form-select" name="sex" id="validationDefault04" required>
            <option selected disabled value="">Выберите...</option>
            <option>Male</option>
            <option>Female</option>
        </select>
    </div>
    <div class="col-md-3">
        <label for="validationDefault05" class="form-label">Дата рождения</label>
        <input type="date" name="date" class="form-control" id="validationDefault05" required>
    </div>
    <div class="col-12">
        <div class="col-md-3">
            <label for="validationDefault06" class="form-label">Вес</label>
            <input type="number" name="weight" class="form-control" id="validationDefault06" required>
        </div>
    </div>
    <div class="col-12">
        <button class="btn btn-primary" type="submit">Отправить форму</button>
    </div>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
