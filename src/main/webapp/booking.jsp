<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Termékek</title>

	<style>
		table {
  			font-family: arial, sans-serif;
 			border-collapse: collapse;
  			width: 60%;
  			margin-left:auto; 
    		margin-right:auto;
		}

		td, th {
  			border: 1px solid #dddddd;
  			text-align: center;
 			padding: 8px;
		}

		tr:nth-child(even) {
  			background-color: #dddddd;
		}
	</style>

</head>
<body>


	
	<h2>Melyik napon szeretne foglalni?</h2>
		<form action="selectedDate">
		<p><input type="date" required name="date" id="date"/></p>
				<input type="submit" value="OK">
	</form>
	
	<h2>Leírás alapján keresés</h2>
	<p><form action = "selected">
		<input type="text" name="description">
		<input type="submit" value="OK">
	</form></p>
    
    <br></br>
    
    <table actio>
		<c:forEach var="event" items="${items}">
      
  		<tr>
    		<th>Azonosító</th>
  		</tr>
  		
  		<tr>
    		<td>${event.id}</td>
  		</tr>
		</c:forEach>
	</table>
    

	
	<h1>Az adatbázis elemei:</h1>
	<form action="showSelected">
	<c:forEach var="event" items="${items}">
   <span><input type="submit" name="eventid" value="${event.id}"></span>

    </c:forEach>
    </form>
    
	<p><form action="back">
  		<input type="submit" value="Vissza">
	</form></p>

</body>
</html>