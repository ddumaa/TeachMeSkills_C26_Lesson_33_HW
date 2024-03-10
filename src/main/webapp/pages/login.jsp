<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${message}</p>
<a href="/home"><button>Return menu</button></a>
</body>
</html>