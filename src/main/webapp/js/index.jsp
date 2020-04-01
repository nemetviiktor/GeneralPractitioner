<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fooldal</title>
<style>
		table {
  			font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		    text-align: center;
		    width: 40%;
		    margin-left: auto;
		    margin-right: auto;

		}

	</style>
</head>
<body>
    <h1 align="center">Adatbázis</h1>
	<table>
		<tr>
			<th><p><form action = "showItems">
			<input type="submit" value="1. Listázás"><br>
		</form></p></th>
			<th><p><form action = "add">
			<input type="submit" value="2. Hozzáadás"><br>
		</form></p></th>
		</tr>
	</table>
</body>
</html>