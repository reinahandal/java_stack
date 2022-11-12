<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login & Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<main>
        <div class="container border border-primary rounded login-reg">
            <h2 class="text-center">Register</h2>
            <form:form action="/register" method="post" modelAttribute="newUser">
                <div class="mb-3">
                    <form:label for="fname" path="firstName" class="form-label">First Name</form:label>
                    <p class="text-danger small"><form:errors path="firstName"/></p>
                    <form:input type="text" path="firstName" id="fname" class="form-control"/>             
                </div>
                <div class="mb-3">
                    <form:label for="lname" path="lastName" class="form-label">Last Name</form:label>
                    <p class="text-danger small"><form:errors path="lastName"/></p>
                    <form:input type="text" path="lastName" id="lname" class="form-control"/>             
                </div>
                <div class="mb-3">
                    <form:label for="email" path="email" class="form-label">Email</form:label>
                    <p class="text-danger small"><form:errors path="email"/></p>
                    <form:input type="text" path="email" id="email" class="form-control"/>             
                </div>
                <div class="mb-3">
                    <form:label for="pw" path="password" class="form-label">Password</form:label>
                    <p class="text-danger small"><form:errors path="password"/></p>
                    <form:input type="password" path="password" id="pw" class="form-control"/>             
                </div>
                <div class="mb-3">
                    <form:label for="confirm" path="confirm" class="form-label">Confirm Password</form:label>
                    <p class="text-danger small"><form:errors path="confirm"/></p>
                    <form:input type="password" path="confirm" id="confirm" class="form-control"/>             
                </div>
                <div class="text-center">
                    <input type="submit" value="Register" class="btn btn-primary shadow-sm rounded">
                </div>
            </form:form>
        </div>
        <div class="container border border-primary rounded login-reg">
            <h2 class="text-center">Log in</h2>
            <form:form action="/login" method="post" modelAttribute="newLogin">
                <div class="mb-3">
                    <form:label for="login-email" path="email" class="form-label">Email</form:label>
                    <p class="text-danger small"><form:errors path="email"/></p>
                    <form:input type="text" path="email" id="login-email" class="form-control"/>             
                </div>
                <div class="mb-3">
                    <form:label for="login-pw" path="password" class="form-label">Password</form:label>
                    <p class="text-danger small"><form:errors path="password"/></p>
                    <form:input type="password" path="password" id="login-pw" class="form-control"/>             
                </div>
                <div class="text-center">
                    <input type="submit" value="Log In" class="btn btn-primary shadow-sm rounded">
                </div>
            </form:form>
        </div>
    </main>
</body>
</html>