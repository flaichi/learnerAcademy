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
	<h1>Student Section</h1>
	<form action="${pageContext.request.contextPath}/html/home.jsp">
		<INPUT type="submit" VALUE="Go Back">
	</form>
	<c:url value="/html/addstudent" var="registerUrl" />
	<form action="addstudent" method="post">
		<table>
				<c:if test="${student.studentId ne null}">
					<tr>
						<td>Student ID:</td>
						<td><input type="text" name="id" value="${student.studentId}"
							readonly="readonly"></td>
					</tr>
				</c:if>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"
						value="${student.firstName}" required></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"
						value="${student.lastName}" required></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" value="${student.email}"
						required></td>
				</tr>
				<tr>
					<td>Mobile:</td>
					<td><input type="tel" name="mobile" value="${student.mobile}"
						required></td>
				</tr>
				
				<tr>
			<td> Class Name:</td>
			<td>
				<select name="classId" id="classroom" required>
					<option value="">Please select Classroom</option>
					<c:forEach items="${classlist}" var="classlist">
					<option value="${classlist.classId}">${classlist.className}</option>
					</c:forEach>
				</select>
			</td>
			
			</tr>

				<c:if test="${student.studentId ne null}">
					<tr>
						<td colspan="2"><input type="submit" value="Update"></td>
					</tr>
				</c:if>
				<c:if test="${student.studentId eq null}">
					<tr>
						<td colspan="2"><input type="submit" value="Save"></td>
					</tr>
				</c:if>
			</table>
		
	</form>
	<br>
	<h1>List of Students</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Class</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${studentlist}" var="student">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				<td>${student.mobile}</td>
				<td>${student.classRoom.className}</td>

				<td>
					<form action="<c:url value="/html/editstudent"/>" method="post">
						<input type="hidden" name="studId" value="${student.studentId}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/html/deletestudent"/>" method="post">
						<input type="hidden" name="studId" value="${student.studentId}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>


	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


</body>
</html>