<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Foglalás</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  	<style>
   	.masthead {
  		height: 50vh;
  		min-height: 100px;
  		background-image: url('../img/headerimage.jpg');
  		background-size: cover;
  		background-position: center;
  		background-repeat: no-repeat;
	}
  }
  </style>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">Szendrőlád</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/">Kezdőlap</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Foglalás
                <span class="sr-only">(current)</span>
              </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Rendelő</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Kapcsolat</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

     <!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
  <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-left">
        <h1 class="text-light font-weight-bold">Foglalás</h1>
      </div>
    </div>
  </div>
</header>

<!-- Page Content -->
	<section class="py-5">
	<h2 class="font-weight-light">Rendelési idő:</h2>
	<table class="table table-striped table-dark">
		<c:forEach var="ohours" items="${ohours}">
  			<tbody>
    			<tr>
      				<td>${ohours.day}</td>
      				<td>${ohours.start} - ${ohours.end}</td>
    			</tr>
  			</tbody>
  		</c:forEach>
	</table>
	</section>
	<h2>Melyik napon szeretne foglalni?</h2>
		<form action="selectedDate">
		<p><input type="date" required name="date" id="date"/></p>
				<input type="submit" value="OK">
	</form>
	
	<h3>**DONT WORKING**</h3>
	<h2>Leírás alapján keresés</h2>
	<p><form action = "selected">
		<input type="text" name="description">
		<input type="submit" value="OK">
	</form></p>
    <h3>**DONT WORKING**</h3>
    <br></br>
    
    <table>
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