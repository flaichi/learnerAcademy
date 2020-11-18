<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<br />
		<h2>Edit Existing</h2>
		<br />
		
		
		<form action="<c:url value="/html/updateteacher"/>" method="Post">
			
			<div class="form-group">
			<input type="hidden" name="techId" value="${teacher.teacherId}">
		</div>
			
			<div class="form-group">
				<label for="name">first name</label> <input type="text"
					class="form-control" name="firstName"
					value="<c:out value='${teacher.firstName}' />" />
			</div>
		<div class="form-group">
				<label for="name">last name</label> <input type="text"
					class="form-control" name="lastName"
					value="<c:out value='${teacher.lastName}' />" />
			</div>
			<div class="form-group">
				<label for="email">teacher Email</label> <input type="email"
					class="form-control" name="email"
					value="<c:out value='${teacher.email}' />">
			</div>
			<div class="form-group">
				<label for="mobile">teacher mobile</label> <input type="tel"
					class="form-control" name="mobile"
					value="<c:out value='${teacher.mobile}' />">
			</div> 
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>