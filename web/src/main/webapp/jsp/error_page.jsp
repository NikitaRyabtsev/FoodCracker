<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<img src="/images/error.png">
<button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>
