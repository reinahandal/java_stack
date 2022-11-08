<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${category.name}"></c:out></h1>
	<a href="/">Home</a>
		<h2>Products</h2>
		<ul>
			<c:forEach var="prod" items="${category.products}">
				<li><c:out value="${prod.name}"></c:out></li>
			</c:forEach>
			
			<h2>Add Product:</h2>
				<form action="/categories/addproduct/" method="post">
				<input type="hidden" name="category" value="${category.id}">
					<label>Products</label>
					<select name="product">
					<c:forEach var="prod" items="${excludedProducts}">
						<option value="${prod.id}"><c:out value="${prod.name}"></c:out></option>
	    			</c:forEach>
	    			</select>
	    			<input type="submit" value="Add" class="btn btn-primary"/>
				</form>
		</ul>
	</div>
</body>
</html>