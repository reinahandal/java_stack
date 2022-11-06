<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>${language.name}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="text-end">
			<a href="/languages">Dashboard</a>
		</div>
		<h2>${language.name}</h2>
		<p>${language.creator}</p>
		<p>${language.version}</p>
		<a href="/languages/${lang.id}/edit" class="btn btn-link">Edit</a>
		<form action="/languages/${lang.id}" method="post" class="delete">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete" class="btn btn-link">
		</form>
	</div>
</body>
</html>