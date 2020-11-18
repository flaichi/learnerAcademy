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
		
		
		<form action="<c:url value="/html/updatestudent"/>" method="Post">
			
			<div class="form-group">
			<input type="hidden" name="stuId" value="${student.studentId}">
		</div>
			
			<div class="form-group">
				<label for="name">first name</label> <input type="text"
					class="form-control" name="firstName"
					value="<c:out value='${student.firstName}' />" />
			</div>
			<div class="form-group">
				<label for="name">last name</label> <input type="text"
					class="form-control" name="lastName"
					value="<c:out value='${student.lastName}' />" />
			</div>
			<div class="form-group">
				<label for="email">teacher Email</label> <input type="email"
					class="form-control" name="email"
					value="<c:out value='${student.email}' />">
			</div>
			<div class="form-group">
				<label for="mobile">student mobile</label> <input type="tel"
					class="form-control" name="mobile"
					value="<c:out value='${student.mobile}' />">
			</div>
			<div class="form-group">
				<label for="name">Class Name</label> 
				<select name="classId" id="classroom">
					<option value="${student.classRoom.classId}">${student.classRoom.className}</option>
					<c:forEach items="${classlist}" var="classlist">
						<option value="${classlist.classId}">${classlist.className}</option>
					</c:forEach>
				</select>
			</div>
			<%-- <div class="form-group">
				<label for="name">student class</label> <input type="text"
					class="form-control" name="classId"
					value="<c:out value='${student.classId}' />">
			</div> --%>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>