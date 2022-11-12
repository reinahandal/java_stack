<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Create a Project</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<style>
	.btn {
		margin-top: 5px;
	}
	</style>
</head>
<body>
	<div class="container">
		<h1>Create a Project</h1>
		<form:form action="/createproject" method="post" modelAttribute="project">
	        <form:label path="title" class="form-label">Project Title:</form:label>
	        <form:errors path="title" class="text-danger small"/>
	        <form:input path="title" class="form-control"/>
	
	        <form:label path="description" class="form-label">Project Description:</form:label>
	        <form:errors path="description" class="text-danger small"/>
	        <form:textarea path="description" class="form-control"/>
	
	        <form:label path="dueDate" class="form-label">Due Date:</form:label>
	        <form:errors path="dueDate" class="text-danger small"/>
	        <form:input type="date" path="dueDate" class="form-control"/>
	   		
	   		<form:input type="hidden" path="teamLead" value="${userId}"/>
	    	<input type="submit" value="Submit" class="btn btn-dark"/>
		</form:form>
		<a href="/dashboard" class="btn btn-outline-dark">Cancel</a>
	</div>
</body>
</html>