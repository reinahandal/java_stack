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
			<h1 class="text-center">Here's Your Omikuji!</h1>
			<div class="card container">
				<p class="text-justify fortune">In ${number} years, you will live in ${city} with ${person} as your roommate, ${hobby} for a living. The next time you see a ${creature}, you will have good luck. Also, ${comment}.</p>
			</div>
			<h4 class="text-center link"><a href="/omikuji">Go back</a></h4>
		</main>
	</body>
</html>