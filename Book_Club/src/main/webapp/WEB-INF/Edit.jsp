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
		<title>Edit Book</title>
	</head>
	<body>
		<div class="d-flex flex-row width: 500px; text-align: center;">
			<h1>Change Your Entry</h1>
		</div>
		
		<div class="d-flex flex-row-reverse p-3 justify-content: right">
			<a href="/books" >Back to the shelves</a>
		</div>

   		<div class="container">
    		<form:form style="width: 500px; height: 300px;" action="/books/${book.id}/edit" method="put" modelAttribute="book">
      			<form:input type="hidden" path="owner"  />
      		<!--hidden input in the form for owner  -->
      		<div class="form-group">
        		<form:label path="title"> Title: </form:label>
        		<form:input  path="title" type="text" class="form-control"/>
       			<form:errors path="title" style="color: red;" />
      		</div>
      		
      		<div class="form-group">
        		<form:label path="author"> Author: </form:label>
        		<form:input  path="author" type="text" class="form-control"/>
        		<form:errors path="author" style="color: red;" />
      		</div>
      		
      		<div class="form-group">
        		<form:label path="thoughts"> My Thoughts: </form:label>
        		<form:textarea type="textarea" path="thoughts"  class="form-control"/>
        		<form:errors path="thoughts" style="color: red;" />
      		</div>
      		<!--Make sure to place for:errors in each input that will render your error message from the models  -->
      		<button type="submit" class="btn btn-secondary mt-3">Submit</button>
    		</form:form>
  		</div>
	</body>
</html>