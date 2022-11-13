<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table class="table">
    <thead>
    <tr>
        <th>Country</th>
        <th>Language</th>
        <th>Percentage</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table1}">                
        <tr>
            <td>${row[0].name}</td>
            <td>${row[1].language}</td>
            <td>${row[1].percentage}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<table class="table">
    <thead>
    <tr>
        <th>Country</th>
        <th># of cities</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table2}">                
        <tr>
            <td>${row[0].name}</td>
            <td>${row[1]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>