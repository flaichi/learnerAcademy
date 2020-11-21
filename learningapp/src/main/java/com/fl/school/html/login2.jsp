<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>
<body>

	
	<form action="LoginServlet" method="Post">
		<input type="text" name="uname" placeholder="Enter Username" />
		<input type="password" name="upass" placeholder="Enter Password" />
		<input type="submit" value="Login" />
	</form>

</body>
</html>