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
        <div class="form-floating ">

            <input type="text" class="form-control" id="floatingInput" name="login" value="" placeholder="login">
            <label for="floatingInput">Логин</label>
        </div>
        <div class="form-floating">
            <input type="text" class="w-100 form-control" name="password" value="" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Пароль</label>
        </div>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="w-50 btn btn-success" type="submit">Войти</button>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="registration"/>
        <input type="submit" class="btn btn-success" value="Регистрация"/>
        <a href="registration.jsp">Reg</a>
    </form>
</main>
<p class="mt-5 mb-3 text-muted">© 2021</p>
</body>
</html>
