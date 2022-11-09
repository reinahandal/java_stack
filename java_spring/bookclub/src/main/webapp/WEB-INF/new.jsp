<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add a book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<style type="text/css">
		.btn {
		margin: 10px;
		}
	</style>
</head>
<body>
<div class="container">
	<p class="text-end"><a href="/books">Back to the shelves</a></p>
	<h1>Add a Book to Your Shelf!</h1>
	<form:form action="/createbook" method="post" modelAttribute="book">
        <form:label path="title" class="form-label">Title</form:label>
        <form:errors path="title" class="text-danger small"/>
        <form:input path="title" class="form-control"/>

        <form:label path="author" class="form-label">Author</form:label>
        <form:errors path="author" class="text-danger small"/>
        <form:input path="author" class="form-control"/>

        <form:label path="thoughts" class="form-label">My thoughts</form:label>
        <form:errors path="thoughts" class="text-danger small"/>
        <form:textarea path="thoughts" class="form-control"/>
   
    	<input type="submit" value="Submit" class="btn btn-dark"/>
	</form:form>    
</div>
</body>
</html>