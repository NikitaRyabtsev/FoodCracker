<%@ page import="by.htp.example.bean.Meal" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="change_meal"/>
    <input type="submit" value="changeMeal"/>
    <input type="date" name="date" value=""/>
    <input type="time" name="time" value=""/>
    <input type="number" name="weight" value=""/>
    <input type="number" name="calories" value=""/>
</form>
<button type="button" name="back" onclick="history.back()">back</button>
</body>
<jsp:include page="/jsp/footer.jsp"/>
</html>
