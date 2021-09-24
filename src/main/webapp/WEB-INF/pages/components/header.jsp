<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 9/24/21
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="${contextPath}" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"> Exhibition </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${contextPath}" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="${contextPath}/exhibitions" class="nav-link px-2 link-dark">Exhibitions</a></li>
            <li><a href="${contextPath}/tickets" class="nav-link px-2 link-dark">Tickets</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <a href="login" class="btn btn-outline-primary me-2">Login</a>
            <a href="registration" class="btn btn-primary">Registration</a>
        </div>
    </header>
</div>

</body>
</html>
