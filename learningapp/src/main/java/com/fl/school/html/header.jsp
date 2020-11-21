<!-- Nav Bar Begin 
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">BG Admin Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Management  </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					  <form  action="/HomeController?action=listteacher"  method="get" class="dropdown-item">
					  <input type="submit" value="Teachers">
					  
					  </form> 							
					<div>
		<c:url value="/Home?action=liststudent" var="registerUrl" />
		<form action="${registerUrl}" method="post">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="Students"></td>
			</tr>
			 
		</table>
		</form>
	</div>
					<a class="dropdown-item" href="#">Subjects</a>
					<a class="dropdown-item" href="#">class Rooms</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">#</a>
				</div>
			</li>
		</ul>
		<ul class="nav navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Admin</a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a href="#print" class="dropdown-item" onClick="window.print()" >Print</a>
                        <div class="dropdown-divider"></div>
                        <a href="#" <c:url value="/home?action=logout" var="registerUrl" /> 
                        <form action="home?action=logout" method="post"></form> class="dropdown-item">Logout</a>
                    </div>
                </li> 




        </ul>
	</div>
</nav>
Nav Bar End -->