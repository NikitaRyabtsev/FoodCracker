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

    <link rel="icon" href="images/FoodCracker.ico">
    <style>
        form{
            margin-block-end: 0;
        }

        .header {
            height: 20vh;
            width: 100%;
            border: 2px solid #000;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .market-modal-page {
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.6);
            display: flex;
            justify-content: center;
            align-items: center;
            opacity: 0;
            visibility: hidden;
        }

        .market-modal-page._active {
            opacity: 1;
            visibility: visible;
        }

        .market-modal-page__body {
            display: flex;

            flex-direction: column;
            width: 40%;
            padding: 30px 50px;
            background-color: #fff;
        }

        .market-modal-page__top {
            display: flex;
            justify-content: space-between;
        }

        .market-modal-page__title {
            font-weight: 700;
            font-size: 2em;
        }

        .market-modal-page__icon-close {
            height: 25px;
            width: 25px;
        }

        .market-modal-page__form {
            width: 50%;
            display: flex;
            justify-content: center;
            flex-direction: column;
        }

        .market-modal-page__textarea {
            margin: 15px 0px;
            min-height: 50px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Вход</title>
</head>
<header class="p-2 bg-dark background-color:text-white">

    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <nav class="navbar navbar-light bg-dark">
                <a class="navbar-brand" href="#">
                    <img src="images/FoodCracker.png" width="40" height="40" class="d-inline-block align-top" alt="">
                </a>
            </nav>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">
                </a></li>
                <li><a href="#" class="nav-link px-2 text-secondary">
                </a></li>
                <li><a href="#" class="nav-link px-2 text-secondary">
                </a></li>
            </ul>
            <a href="#" class="nav-link px-2 text-secondary">
                <section class="market">
                    <div class="market__body">
                        <div class="market__info">
                            <button class=" market__btn  btn btn-success  margin-bottom: 20px">Войти</button>
                        </div>
                    </div>
                </section>
            </a>

            <div class="text-end">
                <a href="#" class="nav-link px-6 text-secondary">
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="go_to_registration"/>
                        <input type="submit" class="btn btn-success  margin-bottom: 20px" value="Регистрация">
                    </form>
                </a>
            </div>
        </div>
    </div>
</header>
<body class="text-center">
<div class="market-modal-page">
    <div class="market-modal-page__body">
        <div class="market-modal-page__top">
            <p class="market-modal-page__title" style="margin-left: 170px">Авторизация</p>
            <img class="market-modal-page__icon-close" src="img/icon-close.svg" alt="close">
        </div>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="authorization"/>
            <div mb-3>

                <input type="login" name="login" value="" class="center w-25 form-control"  placeholder="Логин"
                       style="margin-left: 190px " required autofocus>
            </div>
            </br>
            <div class="mb-3">
                <input type="text" name="password" value="" class="w-25 form-control"  placeholder="Пароль"
                       style="margin-left: 190px " required autofocus>
            </div>
            <div>
                <button class="w-25 btn btn-success" type="submit">Войти</button>
            </div>
        </form>
        <p class="mt-5 mb-3 text-muted">© 2021</p>
    </div>
</div>

<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
    <div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 w-50 text-center text-white overflow-hidden">
        <div class="my-3 py-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
        </div>
        <div class="bg-light box-shadow mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
    </div>
    <div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 w-50 px-md-5 text-center overflow-hidden">
        <div class="my-3 p-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
        </div>
        <div class="bg-dark box-shadow mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
    </div>
</div>
<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
    <div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 w-50 px-md-5 text-center overflow-hidden">
        <div class="my-3 p-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
        </div>
        <div class="bg-white box-shadow mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
    </div>
    <div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 w-50 px-md-5 text-center overflow-hidden">
        <div class="my-3 py-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
        </div>
        <div class="bg-white box-shadow mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
    </div>
</div>
<script>
    if(<%=request.getAttribute("blocked")%>){
        alert("Вы заблокированы,по поводу приичны писать на почту:RyabtsevNukuta@yandex.by");
    }

</script>
<script src="js/script.js"></script>
</body>
<jsp:include page="/jsp/footer.jsp"/>
</html>
