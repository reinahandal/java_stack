<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Book Club</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<style type="text/css">
		.edit-delete {
		display:flex;
		justify-content: center;
		}
	</style>
</head>
<body>
	<div class="container">
		<p class="text-end"><a href="/books">Back to the shelves</a></p>
		<h4>Welcome, ${thisUser.userName}. Welcome to...</h4>
		<h1>The Book Broker!</h1>
		<p>Available Books to borrow:</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${unborrowedBooks}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>
					<td>
					<c:choose>
					<c:when test="${userId == book.user.id}">
						<div class="edit-delete">
							<form action="/books/${book.id}" method="post">
			    				<input type="hidden" name="_method" value="delete">
			    				<input type="submit" value="Delete" class="btn btn-link">
							</form>
							<a href="/books/${book.id}/edit" class="btn btn-link">Edit</a>
						</div>
					</c:when>
					<c:otherwise>
					<p class="text-center"><a href="/bookmarket/borrow/${book.id}" class="btn btn-link">Borrow</a></p>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>Books I'm Borrowing:</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${booksIBorrowed}">
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>
					<td><p class="text-center"><a href="/bookmarket/return/${book.id}" class="btn btn-link">Return</a></p></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>