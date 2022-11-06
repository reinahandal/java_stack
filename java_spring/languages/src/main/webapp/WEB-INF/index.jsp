<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Languages</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<style>
	.container {
		margin-top: 25px;
	}
	.delete {
		display: inline-block;
	}
	</style>
</head>
<body>
	<div class="container">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lang" items="${languages}">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"></c:out></a></td>
					<td><c:out value="${lang.creator}"></c:out></td>
					<td><c:out value="${lang.version}"></c:out></td>
					<td><a href="/languages/${lang.id}/edit" class="btn btn-link">Edit</a>
					<form action="/languages/${lang.id}" method="post" class="delete">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn btn-link">
					</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/languages" method="post" modelAttribute="language">
	    <p>
	        <form:label path="name" class="form-label">Name:</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="creator" class="form-label">Creator:</form:label>
	        <form:errors path="creator" class="text-danger"/>
	        <form:input path="creator" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="version" class="form-label">Version:</form:label>
	        <form:errors path="version" class="text-danger"/>
	        <form:input path="version" class="form-control"/>
	    </p>   
	    <input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>    
	</div>
</body>
</html>