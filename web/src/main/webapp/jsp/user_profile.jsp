<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 15.10.2021
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/FoodCracker.ico">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Профиль</title>
</head>

<body>
<jsp:include page="/jsp/header.jsp"/>
<h1>Hello,user</h1>
<table class="table table-striped table-hover">
    <tr>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>E-mail</td>
        <td>Пол</td>
        <td>Вес</td>
        <td>Дата взвешивания</td>
        <td>Дата Рождения</td>
        <td>Уровень доступа</td>

    <tr>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.password}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.secondName}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.sex}"/></td>
        <td><c:out value="${info.weight}"/></td>
        <td><c:out value="${info.dateOfWeighting}"/></td>
        <td><c:out value="${user.dateOfBirth}"/></td>
        <td><c:out value="${user.role}"/></td>
    </tr>
</table>
<div style="margin-left: 33%">
    <div class="row">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="add_user_weight"/>
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="date" class="form-control w-25" name="date" value=""/>
            <input type="number" name="weight" class="form-control w-25" value=""  required>
            <td><input type="submit" class="w-25 btn btn-success" value="Добавить вес"/></td>
        </form>
    </div>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="get_weight"/>
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="hidden" class="form-control w-25" name="date">
            <td><input type="submit" class="w-25 btn btn-success" value="Статистика веса"/></td>
        </form>
    <h3>Изменить профиль</h3>
    <form action="controller" onsubmit="if(!confirm('Вы уверены что хотите изменить?')) {
                    return false;}" method="post">
        <input type="hidden" name="command" value="edit_profile"/>

        <div class="row">
            <div class="form-group col-md-3">
                <label for="validationDefault01">Логин</label>
                <input type="login" name="login" minlength="6" maxlength="10" place-holder="6-10 символов" class="w-100 form-control" value="${user.login}"
                       id="validationDefault01"
                       placeholder="Логин"
                       required>
            </div>
            <div class="form-group col-md-3">
                <label for="validationDefault02">Пароль</label>
                <input type="text" name="password"  minlength="6" maxlength="10" place-holder="6-10 символов" value="${user.password}" class="w-100 form-control"
                       id="validationDefault02"
                       placeholder="Пароль" required>
            </div>
        </div>

        <div class="form-group col-md-6">
            <label for="validationDefault03">E-mail</label>
            <input type="email" name="email" value="${user.email}" class="w-100 form-control" id="validationDefault03"
                   placeholder="email:vasya@vasya"
                   required>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="exampleFormControlSelect1">Пол</label>
                <select class="form-control" value="${user.sex}" name="sex" id="exampleFormControlSelect1">
                    <option>male</option>
                    <option>female</option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="validationDefault05">Дата рождения</label>
                <input type="date" name="dateOfBirth" value="${user.dateOfBirth}" class="form-control"
                       id="validationDefault05"
                       placeholder="Дата рождения"
                       required>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="validationDefault06">Имя</label>
                <input type="text" name="name" class="w-100 form-control" value="${user.name}" id="validationDefault06"
                       placeholder="Имя" required>
            </div>
            <div class="form-group col-md-3">
                <label for="validationDefault07">Фамилия</label>
                <input type="text" name="secondName" class="w-100 form-control" value="${user.secondName}"
                       id="validationDefault07"
                       placeholder="Фамилия"
                       required>
            </div>
        </div>
        <div class="form-group">
            <input type="hidden" name="id" value="${user.id}">
        </div>
        <div class="form-group col-md-3">
            <label for="validationDefault08">Изменить</label>
            <input type="submit" class="w-100 form-control btn btn-success" value="Изменить" id="validationDefault08">
        </div>
    </form>
</div>
<jsp:include page="/jsp/footer.jsp"/>
<script>
    if(${requestScope.login == 'true'} ){
        alert("Нельзя сменить на данный пароль , он уже кем-то используется")
    }
    if (${requestScope.wrong == 'true'}) {
        alert("Вы сегодня взвешивались , настоятельно рекомендуем взвешиваться утром , на голодный желудок");
    }
</script>
</body>
</html>