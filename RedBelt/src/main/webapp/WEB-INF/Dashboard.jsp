<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<title>Dashboard</title>
	</head>
	<body>
		<div style="" >
			<div class="d-flex flex-row width: 500px; text-align: center;">
				<h1>Welcome, <c:out value="${loggedInUser.name}" /></h1>
				<!--To pass in the logged in user info (Dashboard controller) use the userService "string" for the value  -->
			</div>
			<div class="d-flex flex-row p-3">
				<a href="/logout" >Logout</a>
			</div>
			<div class="text-center">
			<a class="btn btn-secondary" style="margin: 10px;" href="/celebrities/new">Add Celebrity Page</a>
			</div>
		</div>
		
		<div>
			<table class="table table-bordered table-striped" style="width: 1000px; margin: 0 auto;" >
  				<thead>
    				<tr>
      					<th style="color: green; text-align: center;">Celebrity</th>
      					<th style="color: green; text-align: center;">Page Manager</th>
    				</tr>
  				</thead>
  				<tbody>
    			<c:forEach var="celebrity" items="${celebrityList}">
    				<tr class="table-light">
    				<%-- 	<td style="text-align: center;" ><c:out value="${celebrity.id}"/></td> --%>
    					<td style="text-align: center;"><a href="/celebrities/${celebrity.id}" ><c:out value="${celebrity.name}"/></a></td>
    					<td style="text-align: center;" ><c:out value="${celebrity.owner.name}"/></td>
    					<!--To pass in the owner of the one to many variable (User model) use the @OneToMany "string" for the value  -->
    				</tr>
    			</c:forEach>
      			</tbody>
			</table>
		</div>
	</body>
</html>