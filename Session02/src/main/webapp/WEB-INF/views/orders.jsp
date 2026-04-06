<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/7/2026
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head><title>Quản lý đơn hàng</title></head>
<body>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<table border="1" style="border-collapse: collapse; width: 100%;">
    <thead>
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderList}" var="o">
        <tr>
            <td>${o.id}</td>
            <td><c:out value="${o.productName}" /></td>
            <td><fmt:formatNumber value="${o.amount}" type="currency" currencySymbol="VNĐ" /></td>
            <td><fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr>
<p>Tổng lượt xem toàn hệ thống: <strong>${applicationScope.totalViewCount}</strong></p>

<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>
