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
	<h1>Classes  Section</h1>
	<form action="${pageContext.request.contextPath}/html/home.jsp">
	<INPUT type="submit" VALUE="Go Back">
	</form>
	<form action="addclasssubject" method="post">
		<table>
		
			<tr>
			<td> Class Name:</td>
			<td>
				<select name="classId" id="classroom" required="required">
					<option value="">Please select Class</option>
					<c:forEach items="${classlist}" var="classlist">
					<option value="${classlist.classId}">${classlist.className}</option>
					</c:forEach>
				</select>
			</td>
			
			</tr>
			<tr>
			<td> Subject Name:</td>
			<td>
				<select name="subjectId" id="classroom"  required="required">
					<option value="">Please select Subject</option>
					<c:forEach items="${subjectlist}" var="subjectlist">
					<option value="${subjectlist.subjectId}">${subjectlist.subjectName}</option>
					</c:forEach>
				</select>
			</td>
			
			</tr>
			
			<tr>
			<td> Teacher Name:</td>
			<td>
				<select name="teacherId" id="classroom"  required="required">
					<option value="">Please select Teacher</option>
					<c:forEach items="${teacherlist}" var="teacherlist">
					<option value="${teacherlist.teacherId}">${teacherlist.firstName} ${teacherlist.lastName}</option>
					</c:forEach>
				</select>
			</td>
			
			</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
		
		</table>
	</form>
	<br>
	<h1>List of Classes</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Subject </th>
			<th>Teacher</th>
			<th>Update</th>
			<th>Delete</th>		
		</tr>
		<c:forEach items="${classsublist}" var="classsublist">
			<tr>
				<td>${classsublist.id}</td>
				<td>${classsublist.classroom.className}</td>
				<td>${classsublist.subject.subjectName}</td>
				<td>${classsublist.teacher.firstName} ${classsublist.teacher.lastName}</td>
				<td>
					<form action="<c:url value="/html/editclasssubject"/>" method="post">
						<input type="hidden" name="id" value="${classsublist.id}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/html/deleteclasssubject"/>" method="post">
						<input type="hidden" name="id" value="${classsublist.id}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>