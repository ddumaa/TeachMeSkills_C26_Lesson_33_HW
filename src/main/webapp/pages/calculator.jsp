<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1" placeholder="Num 1">
    <select name="type">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" name="num2" placeholder="Num 2">
    <button>Submit</button>
</form>
<p>Result: ${operation.result}</p>
<a href="/home"><button>Return menu</button></a>
</body>
</html>
