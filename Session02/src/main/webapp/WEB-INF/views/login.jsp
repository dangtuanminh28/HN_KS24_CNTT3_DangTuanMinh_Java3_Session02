<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/6/2026
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Danh sách đơn hàng</title></head>
<body>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<table border="1">
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    <c:forEach items="${orderList}" var="o">
        <tr>
            <td>${o.id}</td>
            <td><c:out value="${o.productName}" /></td>
            <td>
                <fmt:formatNumber value="${o.amount}" type="currency" currencySymbol="VNĐ" />
            </td>
            <td>
                <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy" />
            </td>
        </tr>
    </c:forEach>
</table>

<hr>
<p>Tổng lượt xem đơn hàng: <strong>${applicationScope.totalViewCount}</strong></p>

<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>
