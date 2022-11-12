<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/logout">Logout</a></p>
		<h1>Welcome, ${thisUser.firstName}</h1>
		<div class="text-end"><a href="/projects/new" class="btn btn-outline-dark">+ new project</a></div>
		<h3>All projects</h3>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="proj" items="${allProjects}">
				<c:if test="${proj.teamLead.id != userId}">
					<tr>
						<td><a href="/projects/<c:out value="${proj.id}"></c:out>"><c:out value="${proj.title}"></c:out></a></td>
						<td><c:out value="${proj.teamLead.firstName}"></c:out></td>
						<td><fmt:formatDate type="date"  pattern="dd MMM yyyy" value="${proj.dueDate}"/></td>
						<td>
							<form:form method="post" action="/join" modelAttribute="userProject">
								<form:input type="hidden" path="teamMember" value="${userId}"/>
								<form:input type="hidden" path="project" value="${proj.id}"/>
								<input type="submit" value="Join Team" class="btn btn-link"/>
							</form:form>
						</td>
					</tr>
				</c:if>
				</c:forEach>
			</tbody>
		</table>
		<h3>Your projects</h3>
				<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="proj" items="${myProjects}">
					<tr>
						<td><a href="/projects/<c:out value="${proj.id}"></c:out>"><c:out value="${proj.title}"></c:out></a></td>
						<td><c:out value="${proj.teamLead.firstName}"></c:out></td>
						<td><fmt:formatDate type="date"  pattern="dd MMM yyyy" value="${proj.dueDate}"/></td>
						<td>
							<c:choose>
							<c:when test="${proj.teamLead.id == userId}">
								<a href="/projects/edit/${proj.id}" class="btn btn-link">edit</a>
							</c:when>
							<c:otherwise>
								<form:form method="post" action="/leave" modelAttribute="userProject">
									<form:input type="hidden" path="teamMember" value="${userId}"/>
									<form:input type="hidden" path="project" value="${proj.id}"/>
									<input type="submit" value="Leave Team" class="btn btn-link"/>
								</form:form>
							</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>