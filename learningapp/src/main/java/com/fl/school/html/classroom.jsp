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
	<form action="addclass" method="post">
		<table>
			<c:if test="${classroom.classId ne null}">
				<tr>
					<td>classroom ID:</td>
					<td><input type="text" name="id" value=""
						readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>classroom Name:</td>
				<td><input type="text" name="class_name"
					value="" required></td>
			</tr>			

			<c:if test="${classroom.classId ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${classroom.classId eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>List of Classes</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>	
			<th>Update</th>
			<th>Delete</th>			
		</tr>
		<c:forEach items="${classlist}" var="classroom">
			<tr>
				<td>${classroom.classId}</td>
				<td>${classroom.className}</td>		

				<td>
					<form action="<c:url value="/html/editclass"/>" method="post">
						<input type="hidden" name="classId" value="${classroom.classId}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/html/deleteclass"/>" method="post">
						<input type="hidden" name="classId" value="${classroom.classId}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>