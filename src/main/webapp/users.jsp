<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.12.2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="static/css/users.css" type="text/css">
</head>
<body>
	<a href="index.jsp">Go to start</a>

    <form action="delete" method="post">
        <label for="delete">Enter ID for Delete:</label>
        <input type="text" id="delete" name="userIdDelete" />
        <input type="submit" value="Delete" />
    </form>

    <form action="user" method="post">
        <label for="find">Enter ID for find:</label>
        <input type="text" id="find" name="userId" />
        <input type="submit" value="Find user by ID" />
    </form>

	<c:forEach items="${sessionScope.userList}" var="user">
        <div class="user_container">
            <p class="user_container_p">Id: ${user.id}</p>
            <p class="user_container_p">Login: ${user.login}</p>
            <p class="user_container_p">Password: ${user.password}</p>
            <form action="/CarWow_war_exploded/update" method="get">
                <label for="update">Edit:</label>
                <input type="hidden" id="update" name="userIdUpdate" value="${user.id}"/>
                <input type="submit" value="Update user by ID" />
            </form>
        </div>
    </c:forEach>
</body>
</html>
