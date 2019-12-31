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
@WebServlet("/addBook")
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBook() {
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

		Book book = new Book();
		Author author = new Author();

		// Get data from addBook page
		String bookID = request.getParameter("bookID");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String editor = request.getParameter("editor");
		String edition = request.getParameter("edition");
		String year = request.getParameter("year");
		String authorName = request.getParameter("authorName");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String filename = new File(image).getName();		
		
		// Get first name and last name
		String token[] = authorName.split(",");
		String firstName = token[0];
		String lastName = token[1];
		
		// Get author ID from first name and last name
		AuthorDao authorDao = new AuthorDao();
		BookDao bookDao = new BookDao();
		String authorID;
		try {
			authorID = authorDao.getAuthorID(firstName, lastName);
			author.setAuthorid(Integer.parseInt(authorID));
			// Set book
			book.setBookid(Integer.parseInt(bookID));
			book.setIsbn(isbn);
			book.setTitle(title);
			book.setEditor(editor);
			book.setEdition(edition);
			book.setYear(Integer.parseInt(year));	
			book.setAuthor(author);
			book.setImage(filename);
			book.setPrice(Double.parseDouble(price));
			bookDao.setBook(book);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Display book
		request.getRequestDispatcher("WEB-INF/process/Book.jsp").forward(request, response);

	}

}
