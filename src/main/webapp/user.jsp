<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.12.2023
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Users</title>
	<link rel="stylesheet" href="static/css/users.css" type="text/css">
</head>
<body>
	<a href="index.jsp">Go to start</a>
	<c:if test="${sessionScope.UserNotFoundExc eq true}">
		<p>User not found!</p>
	</c:if>
	<c:if test="${sessionScope.UserNotFoundExc ne true}">
		<div class="user_container">
			<p class="user_container_p">Id: ${sessionScope.user.id}</p>
			<p>Login: ${sessionScope.user.login}</p>
			<p>Password: ${sessionScope.user.password}</p>
		</div>
	</c:if>
</body>
</html>
