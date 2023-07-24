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
		<title>Celebrity Details</title>
	</head>
	<body>
		<div>
			<div style="margin: 0 auto; width: 500px;">
				<h1><c:out value="${celebrity.name}"/></h1>
			</div>
			
			<div class="d-flex flex-row p-3 justify-content: right">
				<a href="/home" >Back to the shelves</a>	
			</div>
			
			<div style="margin: 0 auto; width: 800px;">
				<h4>Page Manager: <c:out value="${celebrity.owner.name}" /></h4>
				<h4>Contact: <c:out value="${celebrity.owner.email}" /></h4>
			</div>
			
			<div style="margin: 0 auto; width: 900px;">
				<h4>Details: <c:out value="${celebrity.details}"/></h4>
			</div>
		</div>
		<!--the c:if needs to be used to hide the edit and delete functions from other users  -->
		<c:if test="${userId == celebrity.owner.id}">
		<div class="d-flex flex-row justify-content-center">
			<div class="justify-content-left p-3">
				<a class="btn btn-secondary mt-3 d-flex" data-toggle="collapse" href="/celebrities/${celebrity.id}/edit" >Edit</a>
			</div>
		<!--The edit button doesn't need a function because it renders to another page, meanwhile the delete button needs to be inside a form:form because it uses a function  -->
		</div>
		</c:if>
	</body>
</html>