<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Display time</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/css/style.css">
		<script type="text/javascript" src="js/app2.js"></script>
    </head>
<body>
	<div>
	    <h1 class="time text-center">
	    <fmt:formatDate type="time" value="${date}" pattern="KK:mm a"/></h1>
	</div>
</body>
</html>