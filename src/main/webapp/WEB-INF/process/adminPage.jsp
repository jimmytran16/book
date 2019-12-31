<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>.welcome_admin{padding-right:15px;}</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="adminPage.jsp">Admin Site</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="adminPage.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="adminaction?action=book">Book</a></li>
				<li class="nav-item"><a class="nav-link" href="adminaction?action=author">Author</a></li>
			</ul>
						<%

	if(!(session.getAttribute("FirstName")==null)){ //if the attribute username is not null, means they are logged in
		%>
		<li class="welcome_admin"> Welcome, <b>${FirstName}</b> </li>

	<%
	}
	%>
			<form method="GET" action="LogoutServlet" class="form-inline my-2 my-lg-0">
			
				<button value="value" class="btn btn-outline-success my-2 my-sm-0" type="submit">Log
					out</button>
			</form>
		</div>
	</nav>
	<p>Welcome to Admin Page.</p>
</body>
</html>