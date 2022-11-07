<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>All Dojos</h1>
		<ul>
			<c:forEach var="dojo" items="${dojos}">
				<li><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></li>		
			</c:forEach>
		</ul>
		<a href="/dojos/new">Add Dojo</a>
		<a href="/ninjas/new">Add Ninja</a>
	</div>
</body>
</html>