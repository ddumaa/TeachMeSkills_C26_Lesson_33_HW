<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <h1>Hello ${sessionScope.user.name}!</h1>
        <a href="/calculator"><button>Calculator</button></a>
        <a href="/history"><button>History</button></a>
        <a href="/logout"><button>Logout</button></a>
</c:if>

<c:if test="${sessionScope.user == null}">
    <h1>Hello Guest!</h1>
    <a href="/reg"><button>Registration</button></a>
    <a href="/login"><button>Login</button></a>
</c:if>
</body>
</html>
