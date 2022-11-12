<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Project ${project.title}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/dashboard">Back to Dashboard</a></p>
		<h1>Project Details</h1>
		<table class="table table-borderless">
		<tr>
			<td>Project:</td>
			<td><c:out value="${project.title}"></c:out></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><c:out value="${project.description}"></c:out></td>
		</tr>
		<tr>
			<td>Due Date:</td>
			<td><fmt:formatDate type="date"  pattern="dd/MMM/yyyy" value="${project.dueDate}"/></td>
		</tr>
		</table>
		<c:if test="${isMember == true || project.teamLead.id == userId}">
			<a href="/projects/${project.id}/tasks">See tasks!</a>
		</c:if>
		<c:if test="${project.teamLead.id == userId}">
		<div class="text-end">
			<form action="/projects/${project.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-danger">
			</form>		
		</div>
		</c:if>
	</div>
</body>
</html>