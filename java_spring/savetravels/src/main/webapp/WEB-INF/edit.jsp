<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Edit Expense no. ${expense.id}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<p class="text-end"><a href="/expenses/">Go Back</a></p>
	<h1>Edit Expense</h1>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
    	<input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name" class="form-label">Expense Name:</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="vendor" class="form-label">Vendor:</form:label>
	        <form:errors path="vendor" class="text-danger"/>
	        <form:textarea path="vendor" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="amount" class="form-label">Amount:</form:label>
	        <form:errors path="amount" class="text-danger"/>
	        <form:input path="amount" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="description" class="form-label">Description:</form:label>
	        <form:errors path="description" class="text-danger"/>     
	        <form:input type="description" path="description" class="form-control"/>
	    </p>    
	    <input type="submit" value="Submit" class="btn btn-primary btn-sm"/>
</form:form>
</div>
</body>
</html>