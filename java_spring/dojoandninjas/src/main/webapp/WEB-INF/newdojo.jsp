<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Add Dojo</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<form:form action="/dojos/create" method="post" modelAttribute="dojo">
	    <p>
	        <form:label path="name" class="form-label">Name:</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name" class="form-control"/>
	    </p>
	    <input type="submit" value="Create" class="btn btn-primary"/>
	    </form:form> 	
	</div>
</body>
</html>