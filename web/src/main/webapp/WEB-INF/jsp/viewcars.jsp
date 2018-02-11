<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chep
  Date: 11.02.2018
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sdfsd</title>
</head>
<body>
<table>
    <tr>
        <td>Марка</td>
        <td>Модель</td>
        <td>Год</td>
        <td>Цена</td>
        <td>Мощность</td>
    </tr>
    <c:forEach var="car" items="${requestScope.cars}" >
    <tr>
        <td>${car.manufacture}</td>
        <td>${car.model}</td>
        <td>${car.year}</td>
        <td>${car.standardPrice}</td>
        <td>${car.power}</td>
    </tr>
    </c:forEach>
</table>
pages
<table>
    <tr><p>
        <c:forEach begin="1" end="${requestScope.pages + 1}" varStatus="loop">
            <a href="${pageContext.request.contextPath}/viewcars?page=${loop.index}">${loop.index}</a>
        </c:forEach></p>
        <td></td>
    </tr>
</table>

</body>
</html>
