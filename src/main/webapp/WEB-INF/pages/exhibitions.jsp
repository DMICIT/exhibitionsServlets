<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 9/20/21
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Exhibitions</title>
</head>
<body>

<h2>Exhibitions</h2>

<table>
    <thead>
        <tr>
            <td>#</td>
            <td>Id theme</td>
            <td>Start Date</td>
            <td>End Date</td>
            <td>Start Time</td>
            <td>End Time</td>
            <td>Cost</td>
            <td>Status</td>
        </tr>
    </thead>
    <c:forEach items = "${exhibitions}" var="exhibition">
        <tr>
            <td>${exhibition.id}</td>
            <td>${exhibition.idTheme}</td>
            <td>${exhibition.startDate}</td>
            <td>${exhibition.endDate}</td>
            <td>${exhibition.startTime}</td>
            <td>${exhibition.endTime}</td>
            <td>${exhibition.cost}</td>
            <td>${exhibition.status}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
