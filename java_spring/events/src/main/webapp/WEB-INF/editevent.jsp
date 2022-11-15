<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Edit Event</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h2>Edit Event</h2>
		<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
			<input type="hidden" name="_method" value="put">
			<div class="mb-3">
			<form:label path="name" class="form-label">Name</form:label>
	        <form:errors path="name" class="text-danger small"/>
	        <form:input path="name" class="form-control"/>
			</div>
			<div class="mb-3">
	        <form:label path="date" class="form-label">Date</form:label>
	        <form:errors path="date" class="text-danger small"/>
	        <form:input type="date" path="date" class="form-control"/>
			</div>
	        <div class="mb-3">
	        <form:label path="location" class="form-label">Location</form:label>
	        <form:errors path="location" class="text-danger small"/>
	        <form:input path="location" class="form-control"/>
	        </div>
			<div class="mb-3">
	   		<form:label path="state" class="form-label">State</form:label>
			<form:errors path="state" class="text-danger small"/>
			<form:select path="state">
			<form:options items="${states}"/>
			</form:select>
			</div>   
	   		<form:input type="hidden" path="host" value="${userId}"/>
	    	<input type="submit" value="Submit" class="btn btn-dark"/>
		</form:form>
	</div>
</body>
</html>