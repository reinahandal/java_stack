<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Search Result</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container my-3">
	<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="e" items="${searchResults}">
			<tr>
			<td><a href="/events/<c:out value="${e.id}"></c:out>"><c:out value="${e.name}"></c:out></a></td>
			<td><fmt:formatDate type="date"  pattern="dd/MM/yyyy" value="${e.date}"/></td>
			<td>${e.location}</td>
			<td>${e.state}</td>
			<td>${e.host.firstName}</td>
			<td>
				<c:if test="${userId == e.host.id}">
				<form action="/events/${e.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<a href="/events/${e.id}/edit" class="btn btn-link">Edit</a>
				<input type="submit" value="Delete" class="btn btn-link">
				</form>
				</c:if>
			</td>
			</tr>
			</c:forEach>
			</tbody>
	</table>
</div>
</body>
</html>