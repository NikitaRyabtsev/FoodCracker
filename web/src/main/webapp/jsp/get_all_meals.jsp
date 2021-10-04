<%@ page import="by.htp.example.bean.Meal" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All meals</title>
</head>
<body>
<%
    List<Meal> meals;
    meals = (List<Meal>) request.getAttribute("getMeals");
    out.println(meals);
%>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_meal"/>
    <input type="submit" value="deleteMeal"/>
    <input type="number" name="id" value=""/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="get_meal_by_id"/>
    <input type="submit" value="getMeal"/>
    <input type="number" name="id" value=""/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="change_meal"/>
    <input type="submit" value="changeMeal"/>

</form>
<form action="controller" method="post">
    <input type="hidden" name="id" value="get_meal"/>
    <input type="submit" value="getMeal"/>
    <input type="number" name="id" value=""/>
</form>
<h3>List of Meals : </h3>
<%--<table border="2" cellspacing="2" cellpadding="15">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <td>Id</td>--%>
<%--        <td>Date</td>--%>
<%--        <td>Time</td>--%>
<%--        <td>Weight</td>--%>
<%--        <td>Calories</td>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${meals}" var="meal">--%>

<%--        <tr>--%>
<%--            <td><c:out value="${meal.getId()}"/></td>--%>
<%--            <td><c:out value="${meal.getDate()}"/></td>--%>
<%--            <td><c:out value="${meal.getTime()}"/></td>--%>
<%--            <td><c:out value="${meal.getWeight()}"/></td>--%>
<%--            <td><c:out value="${meal.getCalories()}"/></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
</body>
</html>
