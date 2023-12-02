<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.12.2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
	<h1>This is main page</h1>
    <div style="width: 800px; height: 1000px; border: 1px solid black">
        <c:forEach var="user" items="${userList}">
            <p>Login: ${user.login}, Password: ${user.password}</p>
        </c:forEach>
    </div>

    <c:if test="${not empty sessionScope.userList}">
        <c:forEach var="user" items="${sessionScope.userList}">
            <p>Login: ${user.login}, Password: ${user.password}</p>
        </c:forEach>
    </c:if>

    <%
        // Поместите строку в сессию (пример)
        session.setAttribute("Hello", "Привет, это моя строка!");
        List<String> list = new ArrayList<String>();
        list.add("hello 1");
        list.add("hello 2");
        list.add("hello 3");
        session.setAttribute("Hello2", list);

    %>

    <c:out value="Данные из сессии1: ${Hello}" />
    <c:out value='${sessionScope.Hello}'/>

    <c:forEach var="user" items="${'Hello2'}">
        <p>${'user'}</p>
    </c:forEach>

</body>
</html>
