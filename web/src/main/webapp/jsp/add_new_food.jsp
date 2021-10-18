<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 17.10.2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add_new_food"/>

    <div class="col-md-4">
        <label for="validationDefault1" class="form-label">Имя</label>
        <input type="text" name="name" class="form-control" id="validationDefault1" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault2" class="form-label">Калории</label>
        <input type="number" name="calories" class="form-control" id="validationDefault2" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault3" class="form-label">Белки</label>
        <input type="number" name="proteins" class="form-control" id="validationDefault3" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault4" class="form-label">Жиры</label>
        <input type="number" name="fats" class="form-control" id="validationDefault4" value="" required>
    </div>
    <div class="col-md-4">
        <label for="validationDefault5" class="form-label">Углеводы</label>
        <input type="number" name="carbohydrates" class="form-control" id="validationDefault5" value="" required>
    </div>
    <div class="col-md-3">
        <input type="submit" value="addMeal" class="btn btn-success"/>
    </div>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
