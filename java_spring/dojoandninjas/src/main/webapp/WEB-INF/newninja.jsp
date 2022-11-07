<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Add Ninja</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
	        <form:label path="firstName" class="form-label">First name</form:label>
	        <form:errors path="firstName" class="text-danger"/>
	        <form:input path="firstName" class="form-control"/>
	        
	        <form:label path="lastName" class="form-label">Last name</form:label>
	        <form:errors path="lastName" class="text-danger"/>
	        <form:input path="lastName" class="form-control"/>

	        <form:label path="age" class="form-label">Age</form:label>
	        <form:errors path="age" class="text-danger"/>
	        <form:input type="number" path="age" class="form-control"/>
			
			<form:label path="dojo">Dojo</form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<option value="${dojo.id}">${dojo.name}</option>
	    		</c:forEach>
	    	</form:select>
	    <input type="submit" value="Create" class="btn btn-primary"/>
	    </form:form> 	
	</div>
</body>
</html>