<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${product.name}"></c:out></h1>
		<a href="/">Home</a>
		<h2>Categories</h2>
		<ul>
			<c:forEach var="cat" items="${product.categories}">
				<li><c:out value="${cat.name}"></c:out></li>
			</c:forEach>
			
			<h2>Add Category:</h2>
				<form action="/categories/addproduct/" method="post">
				<input type="hidden" name="product" value="${product.id}">
					<label>Categories</label>
					<select name="category">
					<c:forEach var="catEx" items="${excludedCategories}">
						<option value="${catEx.id}"><c:out value="${catEx.name}"></c:out></option>
	    			</c:forEach>
	    			</select>
	    			<input type="submit" value="Add" class="btn btn-primary"/>
				</form>
		</ul>
	</div>
</body>
</html>