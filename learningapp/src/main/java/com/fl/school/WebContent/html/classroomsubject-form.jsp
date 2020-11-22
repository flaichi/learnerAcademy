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
		
		
		<form action="<c:url value="/html/updateclasssubject"/>" method="Post">
			
			<div class="form-group">
			<input type="hidden" name="id" value="${classsubject.id}">
		</div>
			
			<div class="form-group">
				<label for="className">Class Name</label> 
				<select name="classId" id="classroom">
					<option value="${classsubject.classId}">${classsubject.classroom.className}</option>
					<c:forEach items="${classlist}" var="classlist">
					<option value="${classlist.classId}">${classlist.className}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="subjectName">Subject Name</label> 
				<select name="subjectId" id="classroom">
					<option value="${classsubject.subjectId}">${classsubject.subject.subjectName}</option>
					<c:forEach items="${subjectlist}" var="subjectlist">
					<option value="${subjectlist.subjectId}">${subjectlist.subjectName}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="teacherName">Teacher Name</label> 
				<select name="teacherId" id="classroom">
					<option value="${classsubject.teacherId}">${classsubject.teacher.firstName} ${classsubject.teacher.lastName}</option>
					<c:forEach items="${teacherlist}" var="teacherlist">
					<option value="${teacherlist.teacherId}">${teacherlist.firstName} ${teacherlist.lastName}</option>
					</c:forEach>
				</select>
			</div>
			
			
						
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>