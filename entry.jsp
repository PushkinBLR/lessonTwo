<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Entry</title>
</head>
<body>
<form action="/entry" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="password" name="password" placeholder="password">
    <button>Done</button>
</form>
<p>${requestScope.message}</p>
</body>
</html>
<div>
    <button onclick="location.href='/registration'">Back to registration</button>
</div>
</body>
</html>