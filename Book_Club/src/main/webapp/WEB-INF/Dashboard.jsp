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
			<div class="d-flex flex-row-reverse p-3 justify-content: right">
				<a href="/logout" >Logout</a>
			</div>
			<div class="d-flex flex-row width: 500px; text-align: center;">
				<h4>Books from everyone's shelves:</h4>
			</div>
			<div class="d-flex flex-row-reverse p-3 justify-content: right">
			<a href="/books/new">+ Add a book to my shelf!</a>
			</div>
		</div>
		
		<div>
			<table class="table table-bordered table-striped" style="width: 1000px; margin: 0 auto;" >
  				<thead>
    				<tr>
      					<th style="color: green; text-align: center;">ID</th>
      					<th style="color: green; text-align: center;">Title</th>
      					<th style="color: green; text-align: center;">Author</th>
      					<th style="color: green; text-align: center;">Posted By</th>
    				</tr>
  				</thead>
  				<tbody>
    			<c:forEach var="book" items="${bookList}">
    				<tr class="table-light">
    					<td style="text-align: center;" ><c:out value="${book.id}"/></td>
    					<td style="text-align: center;"><a href="/books/${book.id}" ><c:out value="${book.title}"/></a></td>
      					<td style="text-align: center;" ><a><c:out value="${book.author}"/></a></td>
      					<td style="text-align: center;" ><c:out value="${book.owner.name}"/></td>
    					<!--To pass in the owner of the one to many variable (User model) use the @OneToMany "string" for the value  -->
    				</tr>
    			</c:forEach>
      			</tbody>
			</table>
		</div>
	</body>
</html>