<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 9/21/21
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Tickets</title>
</head>
<body>
<c:import url="components/header.jsp"/>

<div class="container">
    <h2>Tickets</h2>

    <c:choose> <c:when test="${not empty allTickets}">

        <table class="table">
            <thead>
            <tr>
                <td>Id ticket</td>
                <td>Id exhibition</td>
                <td>Id user</td>
                <td>Sold Date</td>

            </tr>
            </thead>
            <c:forEach items="${allTickets}" var="ticket">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.idExhibition}</td>
                    <td>${ticket.idUser}</td>
                    <td>${ticket.soldDate}</td>

                </tr>
            </c:forEach>

        </table>
    </c:when>
        <c:otherwise>Tickets not found</c:otherwise>
    </c:choose>
</div>

<c:import url="components/footer.jsp"/>

</body>
</html>
