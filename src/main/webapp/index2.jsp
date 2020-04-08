<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Title</title>

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

	<script src="jquery-3.4.1.min.js"></script>
	<script src="index.js" type="text/javascript"></script>


</head>
<body>



    <h1 align="center">Új dátum hozzáadása</h1>
	<form action="addItem">
	<table>
            <tr>
                <td><h3>Társadalombiztosítási Azonosító Jel: </h3><p><input type="text" name="taj" required id="taj"/></p></td>
                <td><h3>Családi és utóneve: </h3><p><input type="text" name="name" required id="name"/></p></td>
                <td><h3>Nap: </h3><p><input type="date" required name="date" id="date"/></p></td>
                <td><h3>Számláló: </h3><p><input type="text" required name="counter" id="counter"/></p></td>
                <td><h3>Időpont: </h3><p><input type="text" required name="time" id="time"/></p></td>
            </tr>
            <tr>
                <td colspan="2">
                    <p><input type="submit" value="Hozzáadás" onclick="added()"><p>
                </td>
            </tr>
	</table>
	</form>
	


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