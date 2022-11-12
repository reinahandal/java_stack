<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Project Tasks</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<style>
	.btn {
		margin-top: 5px;
	}
	</style>
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/dashboard">Back to Dashboard</a></p>
		<h1>Project: <c:out value="${project.title}"></c:out></h1>
		<h4>Project Lead: <c:out value="${project.teamLead.firstName}"></c:out></h4>
		<form:form action="/projects/${project.id}/tasks/new" modelAttribute="task" method="post">
				<form:label path="ticket" class="form-label">Add a task ticket for this team:</form:label>
		        <form:errors path="ticket" class="text-danger small"/>
		        <form:textarea path="ticket" class="form-control"/>
		        
		        <form:input type="hidden" path="creator" value="${userId}"/>
		        <form:input type="hidden" path="project" value="${project.id}"/>
				
				<input type="submit" value="Submit" class="btn btn-dark"/>
		</form:form>
		<c:forEach var="task" items="${project.tasks}">
			<p class="fw-bold">Added by <c:out value="${task.creator.firstName}"></c:out> at <fmt:formatDate type="both"  pattern="hh:mm aa, MMM dd" value="${task.createdAt}"/></p>
			<p><c:out value="${task.ticket}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>