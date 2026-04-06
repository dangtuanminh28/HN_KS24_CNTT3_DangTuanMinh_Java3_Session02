<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/6/2026
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px 0; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f8f9fa; }
        .high-score { color: green; font-weight: bold; }
        .low-score { color: red; }
    </style>
</head>
<body>

<h2>Bài 2</h2>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm số</th>
        <th>Xếp loại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="sv" varStatus="loop">
        <tr>
            <td>${loop.count}</td>

            <td><c:out value="${sv.fullName}" /></td>

            <td>${sv.score}</td>

            <td>
                <c:choose>
                    <c:when test="${sv.score >= 9}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 8}">Giỏi</c:when>
                    <c:when test="${sv.score >= 7}">Khá</c:when>
                    <c:when test="${sv.score >= 5}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>