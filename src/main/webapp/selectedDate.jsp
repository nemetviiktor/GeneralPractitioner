<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Termékek</title>


</head>
<body>


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