<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.12.2023
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User update</title>
</head>
<body>
	<a href="users">Back to all users</a>
	<b>User information now</b>
    <div class="user_container">
      <p class="user_container_p">Id: ${sessionScope.userUpdate.id}</p>
      <p>Login: ${sessionScope.userUpdate.login}</p>
      <p>Password: ${sessionScope.userUpdate.password}</p>
    </div>
    <form action="update" method="post">
        <input type="hidden" id="update" name="userId" value="${sessionScope.userUpdate.id}"/>
        <p>${sessionScope.userUpdate.id}</p>
        <input type="text" name="login" value="${sessionScope.userUpdate.login}"/>
        <input type="text" name="password" value="${sessionScope.userUpdate.password}"/>
        <br>
        <input type="submit" value="Update information">
    </form>
</body>
</html>
