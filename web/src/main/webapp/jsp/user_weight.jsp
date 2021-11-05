<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/FoodCracker.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href=/style.css"/>
    <title>Page Title</title>
    <script src="https://www.google.com/jsapi"></script>
</head>
<style>
</style>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div id="chart_div"></div>
<table class="table table-striped table-hover">
    <tr>
        <td>Дата</td>
        <td>Вес(г)</td>
    </tr>

    <c:forEach items="${requestScope.getUserWeight}" var="weight" varStatus="status">
        <tr>
            <td><c:out value="${weight.getDateOfWeighting()}"/></td>
            <td><c:out value="${weight.getWeight()}"/></td>
        </tr>
    </c:forEach>
    <td>
</table>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
    let userInfo = [];
    let weightTicks = [];

    function getUserWeight() {
        let currentInfo = [];
        <c:forEach items="${requestScope.getUserWeight}" var="weight" varStatus="status">;
        currentInfo = [new Date(Date.parse("${weight.getDateOfWeighting()}")), parseFloat("${weight.getWeight()}")];
        userInfo.push(currentInfo);
        </c:forEach>

    }

    getUserWeight();

    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Дата');
        data.addColumn('number', 'Вес');

        data.addRows(userInfo);


        var options = {
            title: 'Ваша статистика',
            width: '80%',
            height: 500,
            pointSize: 5,
            hAxis: {
                format: 'dd.M.yy',
                gridlines: {count: 10},
                pointSize: 5,
            },
            vAxis: {
                gridlines: {count: 10},
                pointSize: 5,
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

        chart.draw(data, options);


    }


</script>
</body>
</html>