<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 11.10.2021
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Login</title>
</head>
<body>

<main class="form-sign in">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="authorization"/>
        <%--        <img class="mb-4" src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">--%>
        <h1 class="h3 mb-3 fw-normal">Введите логин и пароль</h1>
        <div class="col-md-6">
            <label for="validationDefault03" class="form-label">Логин</label>
            <input type="login" name="login" value="" class="form-control" id="validationDefault03" required>
        </div>
        <div class="col-md-6">
            <label for="validationDefault04" class="form-label">Пароль</label>
            <input type="text" name="password" value="" class="form-control" id="validationDefault04" required>
        </div>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="w-50 btn btn-success" type="submit">Войти</button>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="go_to_registration"/>
        <input type="submit" class="btn btn-success" value="Регистрация"/>
        <a href="registration.jsp">Reg</a>
    </form>
</main>
<p class="mt-5 mb-3 text-muted">© 2021</p>
</body>
</html>
