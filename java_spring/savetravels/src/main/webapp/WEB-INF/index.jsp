<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Save Travels</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${expenses}">
				<tr>
					<td><a href="/expenses/${item.id}"><c:out value="${item.name}"></c:out></a></td>
					<td><c:out value="${item.vendor}"></c:out></td>
					<td>$<c:out value="${item.amount}"></c:out></td>
					<td><a href="/expenses/edit/${item.id}">Edit</a></td>
					<td>
					<form action="/expenses/${item.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn btn-danger">
					</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<h2>Add an Expense:</h2>
		<form:form action="/expenses/new" method="post" modelAttribute="expense">
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
	    <input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>    
	</div>
</body>
</html>