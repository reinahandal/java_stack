<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${event.name}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-3">
		<p class="text-end"><a href="/events">Back to Homepage</a></p>
		<h1><c:out value="${event.name}"></c:out></h1>
		<p>Host: <c:out value="${event.host.firstName}"></c:out></p>
		<p>Date: <fmt:formatDate type="both"  pattern="MMMMM dd, yyyy" value="${event.date}"/></p>
		<p>Location: <c:out value="${event.location}"></c:out></p>
		<p>People who are attending this event: ${fn:length(event.attendees)}</p>
		<div class="text-end">
			<c:choose>
			<c:when test="${userIsAttendee == true}">
				<p>You are going to this event</p>
				<form action="/leave/${event.id}" method="post">
					<input type="submit" value="Cancel" class="btn btn-outline-secondary m-2">
				</form>
			</c:when>
			<c:otherwise>
				<form action="/join/${event.id}" method="post">
					<input type="submit" value="Join" class="btn btn-outline-primary m-2">
				</form>
			</c:otherwise>
			</c:choose>
		</div>
		
		<div class="border border-dark rounded p-3 m-3">
		<h3>Message Wall</h3>
			<c:forEach var="msg" items="${event.comments}">
				<hr>
				<p><c:out value="${msg.creator.firstName}"></c:out>: <c:out value="${msg.message}"></c:out></p>
				<p class="small">At <fmt:formatDate type="both"  pattern="hh:mm aa, MMM dd" value="${msg.createdAt}"/></p>
			</c:forEach>
		</div>
		<form:form action="/events/${event.id}/comment" modelAttribute="comment" method="post">
			<form:label path="message" class="form-label">Add comment:</form:label>
			<form:errors path="message" class="text-danger small"/>
			<form:textarea path="message" class="form-control"/>
			        
			<form:input type="hidden" path="creator" value="${userId}"/>
			<form:input type="hidden" path="event" value="${event.id}"/>
					
			<input type="submit" value="Submit" class="btn btn-dark m-3"/>
		</form:form>
	</div>
</body>
</html>