<%@ page import="by.htp.example.bean.Meal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All meals</title>
</head>
<body>
    <%
        Meal meal;
        meal = (Meal) request.getAttribute("getMeals");
        out.println(meal.getId());
    %>
</form>

</body>
</html>
