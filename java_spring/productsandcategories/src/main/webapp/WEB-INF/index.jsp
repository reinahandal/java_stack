<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
	<h1>Home Page</h1>
	<a href="/categories/new">New Category</a>
	<a href="/products/new">New Product</a>
		<table class="table">
		<thead>
			<tr>
			<th>Products</th>
			<th>Categories</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
				<ul>
				<c:forEach var="product" items="${products}">
				<li><a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
				</c:forEach>
				</ul>
				</td>
				
				<td>
				<ul>
				<c:forEach var="category" items="${categories}">
				<li><a href="/categories/${category.id}"><c:out value="${category.name}"></c:out></a></li>
				</c:forEach>
				</ul>
				</td>
			</tr>
		</tbody>
		</table>
	</div>
</body>
</html>