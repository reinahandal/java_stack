<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Counter</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    </head>
<body>
<div class="container">
    <h3 class="text-center">You have visited <a href="/">http://localhost:8080/</a> <c:out value="${count}" default="0"></c:out> time(s).</h3>
    <h3 class="text-center"><a href="/">Test Another Visit?</a></h3>
    <h3 class="text-center"><a href="/destroy">Reset</a></h3>
</div>
</body>
</html>
