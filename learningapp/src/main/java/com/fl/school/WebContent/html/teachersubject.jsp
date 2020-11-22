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
	<h1>Teacher Subject Section</h1>
	<form action="${pageContext.request.contextPath}/html/home.jsp">
		<INPUT type="submit" VALUE="Go Back">
	</form>
	<form action="addteachersub" method="post">
		<table>

			<tr>
				<td>Teacher Name:</td>
				<td><select name="teacherId" id="classroom" required>
						<option value="">Please select Teacher</option>					
						<c:forEach items="${teacherlist}" var="teacherlist">
							<option value="${teacherlist.teacherId}">${teacherlist.firstName}
								${teacherlist.lastName}</option>
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td>Subject Name:</td>
				<td><c:forEach items="${subjectlist}" var="subjectlist">
						<div class="checkbox">
							<label><input type="checkbox" name="subjects"
								value="${subjectlist.subjectId}">${subjectlist.subjectName}</label>
						</div>

					</c:forEach></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>

		</table>
	</form>
	<br>
	<h1>Teacher Subject</h1>
	<table>
		<tr>

			<th>Name</th>
			<th>Subject</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${teacherSubjects}" var="entry">
			<tr>
			<c:if test="${entry.value.size() gt 0}">  
			<td>${entry.key.firstName} ${entry.key.lastName}</td>
				<td><c:forEach items="${entry.value}" var="subject">
				 ${subject.subjectName}
				</c:forEach>
				</td>				
				<td>
					<form action="<c:url value="/html/editteachersub"/>" method="post">
						<input type="hidden" name="id" value="${entry.key.teacherId}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/html/deleteteachersub"/>" method="post">
						<input type="hidden" name="id" value="${entry.key.teacherId}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</c:if>
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>