<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <title>Page Title</title>
</head>
<body>

<div class="info" id="info">
    <p class="info__text">
        Hello, Nikita
    </p>
    <a href="#popup" class="info__link-to-popup">
        To PopUp
    </a>
</div>
<p>Певец Сергей Михалок из группы "Ляпис Трубецкой" ударил во время концерта в Полтаве пьяного мужчину.

    Мужчина оказался уличным музыкантом, который решил высказать свое мнение по поводу творчества Сергея.

    Сперва артист предложил мужчине выйти на сцену, где между ними развязалась перепалка с нецензурной бранью, в итоге которой Михалок ударил мужчину головой.</p>
<div class="popup" id="popup">
    <div class="popup__menu">
        <a href="#info" class="popup__close-icon">x</a>
    </div>
    <div class="popup__content">
        <p class="popup__title">I PopUp</p>
    </div>
</div>
</body>
</html>