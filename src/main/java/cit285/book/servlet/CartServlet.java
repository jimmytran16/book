package cit285.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.domain.Book;
import cit285.book.domain.Cart;
import cit285.book.service.BookServices;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private BookServices bookServices;
	private static final long serialVersionUID = 1L;
	public static List<Book> books = new ArrayList<Book>();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("WEB-INF/process/Cart.jsp").forward(request, response);
		}
		else if(action.equals("buynow")) {
			doPost(request,response);
		}
		else if(action.equals("deletenow")) {
			doPost(request,response);
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart;
		HttpSession session = request.getSession();
		if(session.getAttribute("bookList")==null) {
			 bookServices = new BookServices();
			 ArrayList<Book> bookSession = new ArrayList<>(bookServices.getBooks());
			 session.setAttribute("book",bookSession);		 
		}
		//get action (buy or delete from cart) from parameters - also check if user is logged in
		String action = request.getParameter("action");
		String bookID = request.getParameter("bookId");
		String name = (String) session.getAttribute("FirstName");
		
		//Make instance of cart if doesn't exist! And store cart object into session
		if(session.getAttribute("bookcart")==null) {
			cart = new Cart();
			session.setAttribute("bookcart",cart);
		}

		if (name == null) {
			request.setAttribute("errorMessage", "Please login!");
			request.getRequestDispatcher("WEB-INF/process/users.jsp").forward(request, response);
		}else if (action.equals("buynow")) {
				Book book = new Book();
				System.out.println(bookID);
				bookServices = new BookServices();
				book = bookServices.getBookWithID(Integer.parseInt(bookID));
				//get existing cart
				cart = (Cart)session.getAttribute("bookcart");
				//pass in bookid, and quantity to see if book already exist in cart
				//if book doesn't exist call cart function 'addToCart' to add book
				if(!cart.checkIfBookExist(Integer.parseInt(bookID),Integer.parseInt("1"))) {
						cart.addToCart(book,Integer.parseInt("1"));						
				}
				request.getRequestDispatcher("WEB-INF/process/Cart.jsp").forward(request, response);
		}else if(action.equals("deletenow")) {
				cart = (Cart)session.getAttribute("bookcart");
				cart.deleteBookFromCart(Integer.parseInt(bookID));
				request.getRequestDispatcher("WEB-INF/process/Cart.jsp").forward(request, response);

		}
	}
}


