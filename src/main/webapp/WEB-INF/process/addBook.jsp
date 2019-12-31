<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.book.dao.AuthorDao"%>
<%@ page import="cit285.book.domain.Author"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="adminPage.html">Admin Site</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="adminaction?action=home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="adminaction?action=book">Book</a></li>
				<li class="nav-item"><a class="nav-link" href="adminaction?action=author">Author</a></li>
			</ul>
			<form method="GET" action="LogoutServlet" class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log
					out</button>
			</form>
		</div>
	</nav>
	<form method="post" action="addBook">
		<div class="container center_div">
			<div class="form-group">
				<div class="col-md-4 mb-3">
					<label>BookID</label> <input type="text" class="form-control"
						placeholder="BookID" name="bookID" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>ISBN</label> <input type="text" class="form-control"
						placeholder="ISBN" name="isbn" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Title</label> <input type="text" class="form-control"
						name="title" placeholder="Title" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Editor</label> <input type="text" class="form-control"
						placeholder="Editor" name="editor" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Edition</label> <input type="text" class="form-control"
						placeholder="Edition" name="edition" required>
				</div>
				<div class="col-md-4 mb-3">
					<label>Year</label> <input type="text" class="form-control"
						placeholder="Year" name="year" required>
				</div>

				<div class="col-md-4 mb-3">
					<label>Image</label> <input type="file" name="image">
				</div>

				<div class="col-md-4 mb-3">
					<label>Price</label> <input type="text" class="form-control"
						placeholder="Price" name="price" required>
				</div>

				<div class="form-group col-md-4">
					<label>Author's Name</label> <select class="form-control"
						name="authorName">
						<option selected>Choose a ID</option>
						<%
							AuthorDao authorDao = new AuthorDao();
							ArrayList<Author> authors = new ArrayList<>(authorDao.getAuthor());
							for (Author author : authors) {
						%>
						<option><%=author.getAuthorfirstname() + "," + author.getAuthorlastname()%></option>
						<%
							}
						%>
					</select>
				</div>


			</div>
			<button class="btn btn-primary btnSubmit" type="submit">Add</button>
		</div>
	</form>
</body>
</html>