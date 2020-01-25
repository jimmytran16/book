package cit285.book.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cit285.book.dao.AuthorDao;
import cit285.book.dao.BookDao;
import cit285.book.domain.Author;
import cit285.book.domain.Book;

/**
 * Servlet implementation class addBook
 */
public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String bookId = request.getParameter("bookid");
		BookDao bookDao = new BookDao();
		try {
			bookDao.deleteBook(Integer.parseInt(bookId));
			request.getRequestDispatcher("WEB-INF/process/Book.jsp").forward(request,response);
		
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("WEB-INF/process/Book.jsp").forward(request,response);
		}
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);

	}

}
