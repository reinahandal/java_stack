<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${book.title}"></c:out></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<style type="text/css">
		.edit-delete{
		display: flex;
		}
		.btn {
		margin: 5px;
		}
	</style>
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/books">Back to the shelves</a></p>
		<h1><c:out value="${book.title}"></c:out></h1>
		<c:choose>
		<c:when test="${userId == book.user.id}">
			<h4><span style="color:red">You</span> read <span style="color:rebeccapurple"><c:out value="${book.title}"></c:out></span> by <span style="color:limegreen"><c:out value="${book.author}"></c:out></span></h4>
			<h5>Here are your thoughts:</h5>
		</c:when>
		<c:otherwise>
			<h4><span style="color:red"><c:out value="${book.user.userName}"></c:out></span> read <span style="color:rebeccapurple"><c:out value="${book.title}"></c:out></span> by <span style="color:limegreen"><c:out value="${book.author}"></c:out></span></h4>
			<h5>Here are <c:out value="${book.user.userName}"></c:out>'s thoughts:</h5>
		</c:otherwise>
		</c:choose>
		<hr>
		<p><c:out value="${book.thoughts}"></c:out></p>
		<hr>
		<c:if test="${book.borrower.id != null}">
		<p class="text-primary">This book is currently borrowed by: ${book.borrower.userName}</p>
		</c:if>
		<c:if test="${userId == book.user.id}">
		<div class="edit-delete">
			<form action="/books/${book.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete" class="btn btn-dark">
			</form>
			<a href="/books/${book.id}/edit" class="btn btn-dark">Edit</a>
		</div>
		</c:if>
	</div>
</body>
</html>