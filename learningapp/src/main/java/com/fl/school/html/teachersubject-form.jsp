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
		
		
		<form action="<c:url value="/html/updateteachersub"/>" method="Post">
			
			<div class="form-group">
			<input type="hidden" name="id" value="${ teacher.teacherId}">
		</div>
			
			<div class="form-group">
				<label for="teacherName">Teacher Name</label> 
				<input type="text" name="teacherName" value="${ teacher.firstName} ${ teacher.lastName}" disabled="disabled">
			</div>
			<div class="form-group">
			<label for="subjectName">Subject Taught</label>
			<div>
			<c:forEach items="${subjectlist}" var="subjectlist">
					
						<c:forEach items="${teacherSubjects}" var="teacherSubjects">
								<c:if test="${subjectlist.subjectId eq teacherSubjects.subjectId}">
										<label><input type="checkbox" name=""
											value="${subjectlist.subjectId}" checked="checked" disabled="disabled">${subjectlist.subjectName}</label>
								</c:if>								
						</c:forEach>		
						
				</c:forEach>
			</div>
			</div>
			
			<div class="form-group">
				<label for="subjectName">Update Subjects</label>
				<div class="checkbox">
				
				<c:forEach items="${subjectlist}" var="subjectlist">
					
						<label><input type="checkbox" name="subjects"
											value="${subjectlist.subjectId}">${subjectlist.subjectName}</label>
						
				</c:forEach>
				</div>
					
		
			</div>			
									
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>