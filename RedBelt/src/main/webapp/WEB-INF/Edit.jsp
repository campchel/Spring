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
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<title>Edit Celebrity</title>
	</head>
	<body>
		<div class="d-flex flex-row width: 500px; text-align: center;">
			<h1>Edit Celebrity Page</h1>
		</div>
		
		<div class="d-flex flex-row p-3 justify-content: right">
			<a href="/home" >Home</a>
		</div>

   		<div class="container">
    		<form:form style="width: 500px; height: 300px;" action="/celebrities/${celebrity.id}/edit" method="put" modelAttribute="celebrity">
      			<form:input type="hidden" path="owner"  />
      		<!--hidden input in the form for owner  -->
      		<div class="form-group">
        		<form:label path="name"> Name: </form:label>
        		<form:input  path="name" type="text" class="form-control"/>
       			<form:errors path="name" style="color: red;" />
      		</div>
      		
      		<div class="form-group">
        		<form:label path="details"> Details: </form:label>
        		<form:textarea type="textarea" path="details"  class="form-control"/>
        		<form:errors path="details" style="color: red;" />
      		</div>
      		<!--Make sure to place for:errors in each input that will render your error message from the models  -->
      		<button type="submit" class="btn btn-secondary mt-3">Submit</button>
    		</form:form>
  		</div>
  		<c:if test="${userId == celebrity.owner.id}">
		<div class="d-flex flex-row justify-content-left">
		<!--The edit button doesn't need a function because it renders to another page, meanwhile the delete button needs to be inside a form:form because it uses a function  -->
			<div class="d-inline-flex p-3 justify-content: left">
				<form:form action="/celebrities/${id}" method="delete">
					<button  class="btn btn-info mt-3 pl-2 d-flex">Delete</button>
				</form:form>
			</div>
		</div>
		</c:if>
	</body>
</html>