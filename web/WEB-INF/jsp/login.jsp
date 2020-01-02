<%--
  Created by IntelliJ IDEA.
  User: wii
  Date: 2019/10/22
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆页面</title>
</head>
<body>

<h2>用户登陆</h2>
<br><hr>
<br>

<form action="${pageContext.request.contextPath}/login.action">

用户账号:<input type="text" name="usercode"><br><br>
密码：<input type="password" name="password"><br><br>

<input type="submit" value="登陆">

</form>
</body>
</html>
