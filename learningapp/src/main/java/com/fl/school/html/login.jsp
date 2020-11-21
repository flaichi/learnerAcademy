 <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 >
</head>
<body>

 <div class="container col-md-3 col-md-offset-3" style="overflow: auto">
  <h1>Login Form</h1>
  <form action="checkuser" method="post">
   <div class="form-group">
    <label for="uname">User Name:</label> <input type="text"
     class="form-control" id="username" placeholder="User Name"
     name="username" required>
   </div>
   <div class="form-group">
    <label for="upass">Password:</label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div>
   <button type="submit" class="btn btn-primary">Submit</button>
  </form>
 </div>
</body>
</html>