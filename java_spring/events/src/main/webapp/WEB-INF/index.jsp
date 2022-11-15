<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Welcome!</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<style>
	.submit-btn {
		margin: 10px;
	}

	</style>
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/logout">Logout</a></p>
		<h1>Welcome, ${thisUser.firstName}</h1>
		<p>Here are some of the events happening in your state (${thisUser.state}):</p>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="e" items="${eventsMyState}">
			<c:if test="${e.state == thisUser.state}">
				<tr>
				<td><a href="/events/<c:out value="${e.id}"></c:out>"><c:out value="${e.name}"></c:out></a></td>
				<td><fmt:formatDate type="date"  pattern="dd/MM/yyyy" value="${e.date}"/></td>
				<td>${e.location}</td>
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
			</c:if> 
			</c:forEach>
			</tbody>
		</table>
		<p>Here are some of the events in other states:</p>
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
			<c:forEach var="e" items="${eventsOtherStates}">
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
		<form:form action="/events" method="post" modelAttribute="event">
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
			<form:select path="state" class="form-select">
			<form:option value="">--SELECT--</form:option>
			<form:options items="${states}"/>
			</form:select>
			</div>   
	   		<form:input type="hidden" path="host" value="${userId}"/>
	    	<input type="submit" value="Submit" class="btn btn-dark submit-btn"/>
		</form:form>
	</div>
</body>
</html>