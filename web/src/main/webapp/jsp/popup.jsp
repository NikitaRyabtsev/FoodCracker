<%--
  Created by IntelliJ IDEA.
  User: 37525
  Date: 26.10.2021
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/FoodCracker.ico">
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
    <title>Document</title>

</head>
<body>
<header class="header">
    <p>I`m header</p>
</header>

<section class="market">
    <div class="market__body">
        <div class="market__info">
            <h1 class="market__title">The best shop ever</h1>
            <p class="market__descr">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quos placeat tenetur, corrupti impedit est soluta. Sunt vitae pariatur quibusdam maxime, rem iure? Natus iure ipsam hic tempora, unde rerum labore!
            </p>
            <button class="market__btn">Make order</button>
        </div>
    </div>
</section>

<div class="market-modal-page">
    <div class="market-modal-page__body">
        <div class="market-modal-page__top">
            <p class="market-modal-page__title">Make order</p>
            <img class="market-modal-page__icon-close" src="img/icon-close.svg" alt="close" >
        </div>
        <form  class="market-modal-page__form" action="#">
            <input class="market-modal-page__input" type="text">
            <textarea class="market-modal-page__textarea" placeholder="White here your details"></textarea>
            <input class="market-modal-page__submit" type="submit">
        </form>
    </div>
</div>

<script src="js/script.js"></script>

</body>
</html>
