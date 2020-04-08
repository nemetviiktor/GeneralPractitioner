<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Foglalás</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>Reservable</h2>
	<c:forEach var = "i" begin = "9" end = "12">
		<c:forEach var = "j" begin = "0" end = "45" step = "15">
				<c:set var = "timeVar" scope="session" value = "${i}:${j}"/>
				<c:out value = "${timeVar}"/>
      	</c:forEach>
	</c:forEach>

	
	<%-- >h2>Reserved</h2 >
<table>
	<c:out value = "${fn:length(event)}" />
	<c:forEach var="event" items="${event}">
		<c:set var = "reserved" scope="session" value="${event.counter}" />
		<c:out value = "${reserved}"/>
	</c:forEach>
	<c:forEach var = "i" begin = "0" end = "${fn:length(event)}">
		<c:out value = "${reserved}"/>
	</c:forEach>

<h2>**DONT WORKING**</h2>
<table>
		<c:forEach var="event" items="${event}">
		<c:forEach var = "i" begin = "9" end = "12">
			<c:forEach var = "j" begin = "0" end = "45" step = "15">
					<c:set var = "timeVar" scope="session" value = "${i}:${j}"/>
					<c:out value = "${timeVar}"/>
					<c:if test="${event.time eq '11:11'}">
         		 		<td><c:out value = "${i}"/>:<c:out value = "${j}"/><p></td>
         		 	</c:if>
      			</c:forEach>
			</c:forEach>
      </c:forEach>
	</table>
<h2>**DONT WORKING**</h2  --%>


<p>Mukodik:</p>
	<table>
		<c:forEach var="event" items="${event}">
      
  		<tr>
    		<th>Azonosító</th>
    		<th>Típus</th>
  		</tr>
  		
  		<tr>
    		<td>${event.id}</td>
  		</tr>
		</c:forEach>
	</table>
    
	<p><form action="back">
  		<input type="submit" value="Vissza">
	</form>


</body>
</html>