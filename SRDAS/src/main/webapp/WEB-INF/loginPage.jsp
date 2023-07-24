<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register/Login</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<h1>Welcome to Object Pages!</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h2 class="text-center">Register</h2>
				<div class="form-group">
					<form:label path="name">Name: </form:label>
					<form:input path="name" type="text" class="form-control"/>
					<form:errors path="name" class="text-danger" />
				</div>
		<!--Make sure to place for:errors in each input that will render your error message from the models  -->
		<!--Make sure that you have bcrypted in the services and validations in the models  -->
				<div class="form-group">
					<form:label path="email">Email: </form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
		
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:input path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
		
				<div class="form-group">
					<form:label path="confirm">Confirm Password: </form:label>
					<form:input path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
	<!--buttons need to be inside the form because in saves the info to the form  -->
				<button type="submit" class="btn btn-warning" style="margin: 10px;" >Register</button>
		</form:form>
		<h2 class="text-center">Login</h2>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group">
				<form:label path="email">Email: </form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
		
			<div class="form-group">
				<form:label path="password">Password: </form:label>
				<form:input path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
		
			<button type="submit" class="btn btn-secondary" style="margin: 10px;">Login</button>
		</form:form>
		</div>
	</body>
</html>