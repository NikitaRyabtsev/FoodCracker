<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <link href="/css/style_popup.css" rel="stylesheet" type="text/css">
    <link href="/js/popups.js">
    <title>Login</title>
</head>
<body class="text-center">
<%--<header id="header" class="header lock-padding">--%>
<%--    <div class="header_container _container">--%>
<%--        <a href="#popup" class="header_phone popup-link">PoopUp</a>--%>
<%--    </div>--%>
<%--</header>--%>
<div>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="authorization"/>
        <div mb-3>
            <label for="validationDefault03" class="form-label">Логин</label>
            <input type="login" name="login" value="" class="center w-25 form-control" id="validationDefault03"
                   style="margin-left: 638px;"required autofocus>
        </div></br>
        <div class="mb-3">
            <label for="validationDefault04" class="form-label">Пароль</label>
            <input type="text" name="password" value="" class="w-25 form-control" id="validationDefault04"
                   style="margin-left: 638px "required autofocus>
        </div>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="w-25 btn btn-success" type="submit">Войти</button>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="go_to_registration"/>
        <input type="submit" class="btn btn-success" value="Регистрация"/>
    </form>
</div>
<%--<div class="alert alert-danger" role="alert">--%>
<%--    <button onclick="myFunction()">Try it</button>--%>
<%--</div>--%>
<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">--%>
<%--    Запустить модальное окно--%>
<%--</button>--%>

<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">--%>
<%--    <div class="modal-dialog modal-dialog-centered" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                ...--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script>$('#exampleModalCenter').modal(options)</script>--%>
<p class="mt-5 mb-3 text-muted">© 2021</p>
<script>
    function myFunction() {
        alert("I am an alert box!");
    }
</script>
</body>
</html>
