<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Omikuji</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/CSS/style.css"/>
    </head>
<body>
	<main>
		<h1 class="text-center">Send an Omikuji!</h1>
		<div class="container">
			<form action="/omikuji/submit" method="post" class="border border-dark">
				<div class="mb-3">
					<label for="number" class="form-label">Pick any number from 5 to 25</label>
					<input type="number" name="number" id="number" class="form-control" min="5" max="25">
				</div>
				<div class="mb-3">
					<label for="city" class="form-label">Enter the name of any city.</label>
					<input type="text" name="city" id="city" class="form-control">
				</div>
				<div class="mb-3">
					<label for="person" class="form-label">Enter the name of any real person.</label>
					<input type="text" name="person" id="person" class="form-control">
				</div>
				<div class="mb-3">
					<label for="hobby" class="form-label">Enter professional endeavor or hobby:</label>
					<input type="text" name="hobby" id="hobby" class="form-control">
				</div>
				<div class="mb-3">
					<label for="creature" class="form-label">Enter any type of living thing.</label>
					<input type="text" name="creature" id="creature" class="form-control">
				</div>
				<div class="mb-3">
					<label for="comment" class="form-label">Say something nice to someone:</label>
					<textarea id="comment" name="comment" class="form-control"></textarea>
				</div>
				<p>Send and show a friend</p>
				<div class="text-center">
					<input type="submit" value="Send" class="btn btn-primary">
				</div>
			</form>
		</div>
	</main>
</body>
</html>