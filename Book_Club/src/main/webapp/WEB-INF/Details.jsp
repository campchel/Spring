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
		<title>Book Details</title>
	</head>
	<body>
		<div>
			<div style="margin: 0 auto; width: 500px;">
				<h1><c:out value="${book.title}"/></h1>
			</div>
			
			<div class="d-flex flex-row-reverse p-3 justify-content: right">
				<a href="/books" >Back to the shelves</a>	
			</div>
			
			<div style="margin: 0 auto; width: 500px;">
				<h4><c:out value="${book.owner.name}" /> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h4>
				<h4>Here are <c:out value="${book.owner.name}" />'s thoughts: </h4>
			</div>
			
			<div style="margin: 0 auto; width: 500px;">
				<h5><c:out value="${book.thoughts}"/></h5>
			</div>
		</div>
		<!--the c:if needs to be used to hide the edit and delete functions from other users  -->
		<c:if test="${userId == book.owner.id}">
		<div class="d-flex flex-row justify-content-center">
			<div class="justify-content-left p-3">
				<a class="btn btn-secondary mt-3 d-flex" data-toggle="collapse" href="/books/${book.id}/edit" >Edit</a>
			</div>
		<!--The edit button doesn't need a function because it renders to another page, meanwhile the delete button needs to be inside a form:form because it uses a function  -->
			<div class="d-inline-flex p-3 justify-content: right">
				<form:form action="/books/${id}" method="delete">
					<button  class="btn btn-info mt-3 pl-2 d-flex">Delete</button>
				</form:form>
			</div>
		</div>
		</c:if>
	</body>
</html>