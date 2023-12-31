<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>It's About Time | Celebrating Love and Forever </title>
<link rel="stylesheet" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		
		
		<main>

		
			<!-- COUNTDOWN  -->
				<!-- CENTERED AT THE TOP - HOLD LOCATION  -->
			<div class="counter">
				<p>countdown to go here</p>
			</div>




			<!-- CENTER DETAIL INFORMATION -->
			<div class="details">
				<p>We're getting married!!</p>
				<p>Date: TBD </p>
				<p>Location: Moab, UT</p>
			</div>

			<!-- NAV BAR -->
			<div>
				<ul class="list-group list-group-horizontal">
					<a href="#" class="list-group-item list-group-item-action">Our Story</a>
					  <a href="#" class="list-group-item list-group-item-action">Explore With Us</a>
					  <a href="#" class="list-group-item list-group-item-action">RSVP</a>
				</ul>
			</div>


		</main>
	</div>


</body>
</html>