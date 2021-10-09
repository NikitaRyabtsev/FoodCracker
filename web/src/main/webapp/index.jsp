<%@ page import="by.htp.example.bean.user.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Вход</title>
</head>
<body>
<body class="text-center ">

<main class="form-sign in">
    <form>
<%--        <img class="mb-4" src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">--%>
        <h1 class="h3 mb-3 fw-normal">Введите логин и пароль</h1>

        <div class="form-floating ">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="w-100 btn btn-success" type="submit">Войти</button>
        <p class="mt-5 mb-3 text-muted">© 2021</p>
    </form>
</main>

<script src="/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>



</body>
<%--<form action="controller" method="post">--%>
<%--    <input type="hidden" name="command" value="authorization"/>--%>
<%--    <input type="text" name="login" value=""/>--%>
<%--    <input type="password" name="pass" value=""/>--%>
<%--    <input type="submit" value="Sign in"/><br/>--%>
<%--</form>--%>
</body>
</html>
