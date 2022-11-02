<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ninja Gold</title>
		<link rel="stylesheet" href="/CSS/style.css"/>
    </head>
<body>
    <div class="gold-counter">
        <p>Your Gold: </p>
        <p class="counter-box">${counter}</p>
    </div>
    <div class="activities">
        <div class="activity-box">
            <h2>Farm</h2>
            <p>(earns 10-20 gold)</p>
            <form action="/gold/find" method="post">
                <input type="hidden" name="activity" value="farm">
                <input type="submit" value="Find Gold!" class="button">
            </form>
        </div>
        <div class="activity-box">
            <h2>Cave</h2>
            <p>(earns 5-10 gold)</p>
            <form action="/gold/find" method="post">
                <input type="hidden" name="activity" value="cave">
                <input type="submit" value="Find Gold!" class="button">
            </form>
        </div>
        <div class="activity-box">
            <h2>House</h2>
            <p>(earns 2-5 gold)</p>
            <form action="/gold/find" method="post">
                <input type="hidden" name="activity" value="house">
                <input type="submit" value="Find Gold!" class="button">
            </form>
        </div>
        <div class="activity-box">
            <h2>Quest</h2>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/gold/find" method="post">
                <input type="hidden" name="activity" value="quest">
                <input type="submit" value="Find Gold!" class="button">
            </form>
        </div>
    </div>
    <h3>Activities:</h3>
    <div class="activities-log">
		<c:forEach var="message" items="${allActivities}">
        <p class="activity-num" style="color:${message.get(1)};"><c:out value="${message.get(0)}"></c:out></p>
	    </c:forEach>
    </div>
    <a href="/destroy">Reset</a>
</body>
</html>