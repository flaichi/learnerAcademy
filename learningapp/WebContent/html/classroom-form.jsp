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
		
		
		<form action="<c:url value="/html/updateclass"/>" method="Post">
			
			<div class="form-group">
			<input type="hidden" name="classId" value="${classroom.classId}">
		</div>
			
			<div class="form-group">
				<label for="name">class  name</label> <input type="text"
					class="form-control" name="name"
					value="<c:out value='${classroom.className}' />" />
			</div>		
						
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>