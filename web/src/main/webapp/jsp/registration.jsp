<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 08.10.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>



        .header{
            height: 20vh;
            width: 100%;
            border: 2px solid #000;
            display: flex;
            justify-content: center;
            align-items: center;
        }



        .market-modal-page{
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.6);
            display: flex;
            justify-content: center;
            align-items: center;
            opacity: 0;
            visibility: hidden;
        }

        .market-modal-page._active{
            opacity: 1;
            visibility: visible;
        }

        .market-modal-page__body{
            display: flex;

            flex-direction: column;
            width: 40%;
            padding: 30px 50px;
            background-color: #fff;
        }
        .market-modal-page__top{
            display: flex;
            justify-content: space-between;
        }

        .market-modal-page__title{
            font-weight: 700;
            font-size: 2em;
        }

        .market-modal-page__icon-close{
            height: 25px;
            width: 25px;
        }
        .market-modal-page__form{
            width: 50%;
            display: flex;
            justify-content: center;
            flex-direction: column;
        }

        .market-modal-page__textarea{
            margin: 15px 0px;
            min-height: 50px;
        }

    </style>
    <link rel="icon" href="images/FoodCracker.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Регистрация</title>
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
    </div>
</div>
</header>
<body class="body">
<br/>
<h2 class="text-center">Ваш путь к успеху</h2>
<h1 class="text-center">FoodCracker.by </h1>
<h3 class="text-center"><img src="images/FoodCracker.png" width="400" height="400"
                                    class="d-inline-block align-top" alt=""></h3>
<div class="reg">
    <div class="form-row">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="registration"/>
            <div class="row">
                <div class="form-group col-md-3" style="
    margin-left: 350px">
                    <label for="validationDefault01">Логин</label>
                    <input type="login" name="login" class="w-100 form-control" id="validationDefault01"
                           placeholder="Введите логин" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="validationDefault02">Пароль</label>
                    <input type="text" name="password" class="w-100 form-control" id="validationDefault02"
                           placeholder="Пароль" required>
                </div>
            </div>
            <div class="form-group col-md-6" style="
    margin-left: 350px">
                <label for="validationDefault03">E-mail</label>
                <input type="email" name="email" class="w-100 form-control" id="validationDefault03"
                       placeholder="email:vasya@vasya" required>
            </div>
                <div class="form-group col-md-3" style="
    margin-left: 350px">
                    <label for="exampleFormControlSelect1">Пол</label>
                    <select class="form-control" name="sex" id="exampleFormControlSelect1">
                        <option>male</option>
                        <option>female</option>
                    </select>
                </div>
                <div class="form-group col-md-3" style="
    margin-left: 350px">
                    <label for="validationDefault05">Дата рождения</label>
                    <input type="date" name="dateOfBirth" class="form-control" id="validationDefault05"
                           placeholder="Дата рождения" required>
                </div>
            <div class="row">
                <div class="form-group col-md-3" style="
    margin-left: 350px">
                    <label for="validationDefault06">Имя</label>
                    <input type="text" name="name" class="w-100 form-control" id="validationDefault06" placeholder="Имя"
                           required>
                </div>
                <div class="form-group col-md-3">
                    <label for="validationDefault07">Фамилия</label>
                    <input type="text" name="secondName" class="w-100 form-control" id="validationDefault07"
                           placeholder="Фамилия"
                           required>
                </div>
            </div>
            <div class="form-group">
                <input type="hidden" name="blockUser" class="form-control" value="unblock" required>
            </div>
            <div class="form-group">
                <input type="hidden" name="role" class="form-control" value="user" required>
            </div>
            <button type="submit" class=" form-group col-md-3 btn btn-success" style="
    margin-left: 350px">Зарегистрироваться</button>
        </form>
    </div>
    </form>
</div>
<div class="market-modal-page">
    <div class="market-modal-page__body">
        <div class="market-modal-page__top">
            <p class="market-modal-page__title" style="margin-left: 190px">Авторизация</p>
            <img class="market-modal-page__icon-close" src="img/icon-close.svg" alt="close">
        </div>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="authorization"/>
            <div mb-3>
                <input type="login" name="login" value="" placeholder="Логин" class="center w-25 form-control"
                       style="margin-left: 217px " required autofocus>
            </div>
            </br>
            <div class="mb-3">
                <input type="text" name="password" value="" placeholder="Пароль" class="w-25 form-control"
                       style="margin-left: 217px " required autofocus>
            </div>
            <div>
                <button class="w-25 btn btn-success" style="margin-left: 217px"type="submit">Войти</button>
            </div>
        </form>
        <p class="mt-5 mb-3 text-muted">© 2021</p>
    </div>
</div>
<jsp:include page="/jsp/footer.jsp"/>
<script src="js/script.js"></script>
<script>
    if(<%=request.getAttribute("existLogin")%>){
        alert("Такой пользовтель уже существует");
    }
</script>
</body>
</html>
