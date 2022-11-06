<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Edit ${language.name}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<style>
		.links {
		display: flex;
		justify-content: flex-end;
		}
	</style>
</head>
<body>
	<div class="container">
	<div class="links">
		<form action="/languages/${lang.id}" method="post" class="delete">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete" class="btn btn-link">
		</form>
		<a href="/languages" class="btn btn-link">Dashboard</a>
	</div>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
	    	<input type="hidden" name="_method" value="put">
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