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
	<h1>Teacher   Section</h1>
	<!--  <FORM> <INPUT TYPE="button" VALUE="Go Back" onClick="history.go(-1)"> </FORM>-->
	<form action="${pageContext.request.contextPath}/html/home.jsp">
	<INPUT type="submit" VALUE="Go Back">
	</form>
	<c:url value="/Home?action=addteacher" var="registerUrl" />
	<form action="addteacher" method="post">
		<table>
			<c:if test="${teacher.teacherId ne null}">
				<tr>
					<td>Teacher ID:</td>
					<td><input type="text" name="id" value="${teacher.teacherId}"
						readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"
					value="" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					value="" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value=""
					required></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="tel" name="mobile" value=""
					required></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>Subjects:</td> -->
<!-- 				 display drop down multi list -->
<!-- 				<td><input type="list" name="subject" value="${subject.id}" -->
<!-- 					required></td> -->
<!-- 			</tr> -->
			

			<c:if test="${teacher.teacherId ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${teacher.teacherId eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>List of Teachers</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${teacherlist}" var="teacher">
			<tr>
				<td><c:out value="${teacher.teacherId}"></c:out></td>
				<td><c:out value="${teacher.firstName}"></c:out></td>
				<td><c:out value="${teacher.lastName}"></c:out></td>
				<td><c:out value="${teacher.email}"></c:out></td>
				<td><c:out value="${teacher.mobile}"></c:out></td>
								 
				<td>
					<form action="<c:url value="/html/editteacher"/>" method="post">
						<input type="hidden" name="techId" value="${teacher.teacherId}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/html/deleteteacher"/>" method="post">
						<input type="hidden" name="techId" value="${teacher.teacherId}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
