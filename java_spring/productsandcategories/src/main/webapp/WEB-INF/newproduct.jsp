<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Add Product</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<a href="/">Home</a>
		<form:form action="/products/create" method="post" modelAttribute="product">
	        <form:label path="name" class="form-label">Name:</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name" class="form-control"/>
	        
	        <form:label path="description" class="form-label">Description:</form:label>
	        <form:errors path="description" class="text-danger"/>
	        <form:textarea path="description" class="form-control"/>
	        
	       	<form:label path="price" class="form-label">Price:</form:label>
	        <form:errors path="price" class="text-danger"/>
	        <form:input path="price" class="form-control"/>
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	    </form:form> 	
	</div>
</body>
</html>