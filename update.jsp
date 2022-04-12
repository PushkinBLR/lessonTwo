<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<thead>
    <title>Update</title>
<tr>
    <th>id</th>
    <th>login</th>
    <th>password</th>
    <th>lastname</th>
    <th>firstname</th>

</tr>
</thead>
<tbody>
<form action="/entry/update" method="post">
    <td><c:out value="${user.id}"/></td>
    <td><c:out value="${user.login}"/></td>
    <td><c:out value="${user.password}"/></td>
    <td><c:out value="${user.lastname}"/></td>
    <td><c:out value="${user.firstname}"/></td>
    <td><a href="/user/update?id= <c:out value='${user.id}'/>">Update</a>;
        <a href="/user/delete?id= <c:out value='${user.id}'/>">Delete</a>;

    </td>
</form>
<p>${requestScope.message}</p>
</tbody>
</html>
<div>
    <button onclick="location.href='/entry'">Back to entry</button>
</div>
</body>
</html>