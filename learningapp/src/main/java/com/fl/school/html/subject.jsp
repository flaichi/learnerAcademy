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
	<h1>Subject  Section</h1>
	<form action="${pageContext.request.contextPath}/html/home.jsp">
	<INPUT type="submit" VALUE="Go Back">
	</form>
	<form action="addsubject" method="post">
		<table>
			<c:if test="${subject.subjectId ne null}">
				<tr>
					<td>subject ID:</td>
					<td><input type="text" name="id" value="${subject.subjectId}"
						readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td> Name:</td>
				<td><input type="text" name="name"
					value="${subject.subjectName}" required></td>
			</tr>
			<tr>
				<td>Code:</td>
				<td><input type="text" name="code"
					value="${subject.subjectCode}" required></td>
			</tr>
			
			<c:if test="${subject.subjectId ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${subject.subjectId eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>List of Subjects</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Code</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<c:forEach items="${subjectlist}" var="subject">
			<tr>
				<td>${subject.subjectId}</td>
				<td>${subject.subjectName}</td>
				<td>${subject.subjectCode}</td>		
				
				<td>
					<form action="<c:url value="editsubject"/>" method="post">
						<input type="hidden" name="subjId" value="${subject.subjectId}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="deletesubjet"/>" method="post">
						<input type="hidden" name="subjId" value="${subject.subjectId}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>