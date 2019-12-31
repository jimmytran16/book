package cit285.book.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cit285.book.dao.AuthorDao;
import cit285.book.domain.Author;

/**
 * Servlet implementation class addAuthor
 */
@WebServlet("/addAuthor")
public class addAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		AuthorDao authorDao = new AuthorDao();

		Author author = new Author();

		String authorID = request.getParameter("authorID");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		author.setAuthorid(Integer.parseInt(authorID));
		author.setAuthorfirstname(firstName);
		author.setAuthorlastname(lastName);
		try {
			authorDao.setAuthor(author);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/process/Author.jsp").forward(request, response);
	}

}
