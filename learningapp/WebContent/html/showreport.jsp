<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learner Academy OMS</title>

<style type="text/css">
body {
	text-align: center;
}

table {
	margin-left: 15%;
	min-width: 70%;
	border: 1px solid #CCC;
	border-collapse: collapse;
}

table tr {
	line-height: 30px;
}

table tr th {
	background: #000033;
	color: #FFF;
}

table tr td {
	border: 1px solid #CCC;
	margin: 5px;
}

input[type=text], input[type=email], input[type=tel] {
	min-width: 60%;
}

input[type=submit], a {
	background: green;
	padding: 5px;
	margin: 5px;
	color: #FFF;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>Class Report</h1>
	<form action="${pageContext.request.contextPath}/html/home.jsp">
		<INPUT type="submit" VALUE="Go Back">
	</form>
	<form action="showreport" method="post">
		<table>

			<tr>
				<td>Class Name:</td>
				<td><select name="classId" id="classroom">
						<option value="${selectedClassroom.classId}">${selectedClassroom.className }</option>
						<c:forEach items="${classlist}" var="classlist">
							<option value="${classlist.classId}">${classlist.className}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<br>
	<h1>Class Name: ${selectedClassroom.className }</h1>
	<br>
	<h1>List of Subjects</h1>
	<table>
		<tr>			
			<th>Subject Name</th>		
		</tr>
		<c:forEach items="${subjectlist}" var="subject">
			<tr>				
				<td>${subject.subjectName}</td>			
			</tr>
		</c:forEach>
	</table>
	<br>
	<h1>List of Teachers</h1>
	<table>
		<tr>
			<th>Teacher Name</th>		
		</tr>
		<c:forEach items="${teacherlist}" var="teacher">
			<tr>
				<td>${teacher.firstName} ${teacher.lastName}</td>				
			</tr>
		</c:forEach>
	</table>
	<br>
	<h1>List of Students</h1>
	<table>
		<tr>
			<th>Student Name</th>		
		</tr>
		<c:forEach items="${studentlist}" var="student">
			<tr>
				<td>${student.firstName} ${student.lastName}</td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>