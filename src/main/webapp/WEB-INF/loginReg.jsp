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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

<title></title>
</head>
<body>

	<div>
		<div class="row justify-content-evenly p-3">
		
			<!-- REGISTER -->
			<div class="col border border-white">
				<h4 class="p-1">Register</h4>
				<form:form action="/register" method="POST" modelAttribute="newUser">
				
					<div class="form-floating mb-3">
							<form:input path="firstName" class="form-control" placeholder="First Name"/>
							<form:label path="firstName" for="floatingInput" >First Name</form:label>
							<form:errors path="firstName" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="lastName" class="form-control" placeholder="Last Name"/>
						<form:label path="lastName" for="floatingInput" >Last Name</form:label>
						<form:errors path="lastName" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="email" type="email" class="form-control" placeholder="name@example.com"/>
						<form:label path="email" for="floatingInput">Email</form:label>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="password" type="password" class="form-control" placeholder="Password"/>
						<form:label path="password" for="floatingPassword">Password</form:label>
						<form:errors path="password" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="confirmPassword" type="password" class="form-control" placeholder=" Confirm Password"/>
						<form:label path="confirmPassword" for="floatingPassword">Confirm Password</form:label>
						<form:errors path="confirmPassword" class="text-danger"/>
					</div>
					<button class="btn btn-outline-dark">Register Now!</button>

				</form:form>
			</div>

			<!-- LOGIN -->
			<div class="col border border-white">
				<h4 class="p-1">Login</h4>
				<form:form action="/login" method="POST" modelAttribute="newLogin">
				

					<div class="form-floating mb-3">
						<form:input path="email" type="email" class="form-control" placeholder="name@example.com"/>
						<form:label path="email" for="floatingInput">Email</form:label>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="password" type="password" class="form-control" placeholder="Password"/>
						<form:label path="password" for="floatingPassword">Password</form:label>
						<form:errors path="password" class="text-danger"/>
					</div>

					<button class="btn btn-outline-dark">Login Now!</button>

				</form:form>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>