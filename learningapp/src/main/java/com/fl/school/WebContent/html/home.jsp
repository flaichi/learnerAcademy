<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>School Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- Content Begin -->
	<div class="container">
		<br /> <br />
		<h2>Welcome to School Management Portal</h2>


		<br>
		<div class="row">
			<div class="col-sm-4">
				<c:url value="listteacher" var="registerUrl" />
				<form action="listteacher" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="Teachers"></td>
						</tr>

					</table>
				</form>
			</div>
			<div class="col-sm-4">
				<c:url value="liststudent" var="registerUrl" />
				<form action="liststudent" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="Students"></td>
						</tr>

					</table>
				</form>
			</div>
			<div class="col-sm-4">
				<c:url value="/Home?action=listsubjects" var="registerUrl" />
				<form action="listsubjects" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="Subjects"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<c:url value="listteachersub" var="registerUrl" />
				<form action="listteachersub" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="TeacherSubjects"></td>
						</tr>

					</table>
				</form>
			</div>
			<div class="col-sm-4">
				<c:url value="/Home?action=listclass" var="registerUrl" />
				<form action="listclass" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="Classes"></td>
						</tr>

					</table>
				</form>
			</div>
			<div class="col-sm-4">
				<c:url value="/Home?action=listclasssubject" var="registerUrl" />
				<form action="listclasssubject" method="post">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="ClassesSubjectTeacher"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<c:url value="/Home?action=classreport" var="registerUrl" />
				<form action="classreport">
					<table>
						<tr>
							<td colspan="2"><input type="submit" value="ClassReport"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>

	</div>
	<!-- Content End -->

	<!-- Footer Begin -->
	<!-- Footer End -->

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>