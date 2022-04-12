<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<div>
    <h1>Registration new user</h1>
</div>

<div>
    <%
        if (request.getAttribute("login") != null) {
            out.println("<p>User '" + request.getAttribute("login") + "' added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>Login:
                <input type="text" name="login"><br />
            </label>
            <label>Password:
                <input type="password" name="password"><br />
            </label>
            <label>Lastname:
                <input type="text" name="lastname"><br />
            </label>
            <label>Firstname:
                <input type="text" name="firstname"><br />
            </label>
            <input type="submit" value="Save"/>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>