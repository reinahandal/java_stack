<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
	<div class="container">
		<h1><c:out value="${book.title}"></c:out></h1>
		<p>Description: <c:out value="${book.description}"></c:out></p>
		<p>Language: <c:out value="${book.language}"></c:out></p>
		<p>Number of pages: <c:out value="${book.numberOfPages}"></c:out></p>
	</div>
</body>
</html>