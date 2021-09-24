<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 9/21/21
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>Exhibition</title>
</head>
<body>
<c:import url="components/header.jsp"/>
<div class="container">
<h2>Exhibition</h2>


<table class="table">
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

</table>
</div>
<c:import url="components/footer.jsp"/>

</body>
</html>
