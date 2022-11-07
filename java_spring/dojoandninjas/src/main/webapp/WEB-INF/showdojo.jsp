<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${dojo.name}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>${dojo.name} Ninjas</h1>
			<table class="table table-striped">
				<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age Name</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<tr>
						<td><c:out value="${ninja.firstName}"></c:out></td>
						<td><c:out value="${ninja.lastName}"></c:out></td>
						<td><c:out value="${ninja.age}"></c:out></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>