<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>History</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<ul>
    <c:forEach items="${history}" var="operation">
        <li>${operation}</li>
    </c:forEach>
</ul>
<a href="/home"><button>Return menu</button></a>
</body>
</html>