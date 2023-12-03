<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>CarWow</h2>
<form action="main" method="post">
    <input type="text" name="login" value="user"/>
    <input type="text" name="password" value="12345678"/>
    <br>
    <input type="submit" value="Add new User">
</form>

<a href="/CarWow_war_exploded/users">Get all users</a>

</body>
</html>
