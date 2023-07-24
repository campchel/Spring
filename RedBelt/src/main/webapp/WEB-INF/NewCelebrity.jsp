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
		<title>New Celebrity</title>
	</head>
	<body>
		<div class="d-flex flex-row width: 500px; text-align: center;">
			<h1>New Celebrity Page</h1>
		</div>
		<div class="d-flex flex-row p-3 justify-content: right">
			<a href="/home" >Home</a>
		</div>
		
   		<div class="container" >
    		<form:form style="width: 500px; height: 300px;" action="/celebrities/new" method="post" modelAttribute="newCelebrity">
      			<form:input type="hidden" path="owner" value="${userId}" />
      			<!--hidden input in the form for owner  -->
      			<div class="form-group">
      				<form:label path="name"> Name: </form:label>
        			<form:input  path="name" type="text" class="form-control"  placeholder="Enter celebrity name"/>
        			<form:errors path="name" style="color: red;"/>
      			</div>
      			
      			<div class="form-group">
        			<form:label path="details"> Details: </form:label>
        			<form:textarea type="textarea" path="details"  class="form-control" placeholder="Enter details"/>
        			<form:errors path="details" style="color: red;"/>
      			</div>
      			<!--buttons need to be inside the form because in saves the info to the form  -->
      			<button type="submit" class="btn btn-secondary mt-3">Create</button>
    		</form:form>
 		 </div>
	</body>
</html>