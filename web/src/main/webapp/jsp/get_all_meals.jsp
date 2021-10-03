
<%@ page import="by.htp.example.bean.Meal" %>
<%@ page import="java.util.List" %>
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
<h3>List of Meals : </h3>
<table border="2" cellspacing="0" cellpadding="2">
    <tr>
        <td>Id</td>
        <td>Date</td>
        <td>Time</td>
        <td>Weight</td>
        <td>Calories</td>
    </tr>

    <c:forEach var="meal" items="${meals}" >
        <ul>
            <p><c:out value="${meal}" /></p>
            <p><c:out value="${meal.value.date}" /></p>
            <p><c:out value="${meal.value.time}" /></p>
            <p><c:out value="${meal.value.weight}" /></p>
            <p><c:out value="${meal.value.calories}" /></p>
        </ul>
    </c:forEach>
</table>
</body>
</html>
