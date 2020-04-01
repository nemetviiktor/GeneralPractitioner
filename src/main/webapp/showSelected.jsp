<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	
	
	p{
		font-Size:30px;
		background-color:red;
	}
</style>


</head>
<body>
	  	<p>Dátum: <br> id: ${event.id}<br> description: ${event.description} <br> date:  ${event.date}<br> time:  ${event.time}<br> </p>

		<a href = "index.jsp">HOME</a>

</body>
</html>