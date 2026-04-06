<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/6/2026
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Đăng nhập hệ thống</title></head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    Tài khoản: <input type="text" name="username" required><br><br>
    Mật khẩu: <input type="password" name="password" required><br><br>
    <button type="submit">Vào hệ thống</button>
</form>
</body>
</html>