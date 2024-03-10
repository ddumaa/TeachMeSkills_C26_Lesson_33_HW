<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<form action="/reg" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<a href="/home"><button>Return menu</button></a>
</body>
</html>
