<%@page import="java.net.CookieStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("admin") == null) {
			response.sendRedirect("html/login.jsp");
		} 
	
		String admin = (String) session.getAttribute("admin");
			
		String userName = null;
		String sessionId = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("admin"))
					userName = cookie.getValue();
				if(cookie.getName().equals("JSESSIONID"))
					sessionId = cookie.getValue();	
			}
		}
		
	%>
	<h3>Hello <%= userName %>, You are successfully Logged IN.</h3>
	<h3> Session Created : <%=sessionId %></h3>
	<br/>
	<form action="html/home.jsp" method="post">
		<input type="submit" value="Enter Learner's Academy Panel" />
	</form>
</body>

</html>