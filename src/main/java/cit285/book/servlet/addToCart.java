package cit285.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.domain.Book;



@WebServlet("/addToCart")
	
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = -722145894595269619L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { 
		HttpSession sess = request.getSession();
		//get book data from session
		Book record = null;
		HashMap<Book,Integer> bookMap;
		HashMap<Book,Integer> updateCart;
		String action = request.getParameter("action");
		String bookid = request.getParameter("bookId");
		ArrayList<Book> retrieveBookList = (ArrayList<Book>)sess.getAttribute("books");
		for(Book book:retrieveBookList) {
			if(String.valueOf(book.getBookid()).equals(bookid)) {
				record = book;
				break;
			}
		}
		boolean testing = false;
		
		if(action.equals("buynow")) {
			
			try {
			/*IF CART DOESNT EXIST IN SESSION, ADD BOOK TO HASHMAP AND CREATE CART*/
			if(sess.getAttribute("cart")==null) {
				bookMap = new HashMap<Book,Integer>();
				bookMap.put(record,1);
				sess.setAttribute("cart",bookMap);
				sess.setAttribute("cartQuantity",bookMap.size());

			}
			/*get the book info with bookid*/
			else {
//				bookInCart.add(book.getBookWithID(Integer.parseInt(bookid)));
				bookMap = (HashMap<Book,Integer>)sess.getAttribute("cart");
				/*ITERATE THROUGH THE MAP AND COMPARE BOOK ID TO RECENT ADDED TO CART*/
				for(HashMap.Entry<Book,Integer> entry : bookMap.entrySet()) {
					/*IF BOOK ALREADY EXISTS IN CART, THEN ADD INCREMENT THE QUANTITY*/
					if(entry.getKey().getBookid()==Integer.parseInt(bookid)) {
						bookMap.put(entry.getKey(),entry.getValue()+1);
						System.out.println(entry.getKey().getTitle()+" Quantity: "+entry.getValue());
						sess.setAttribute("cartQuantity",bookMap.size());

						sess.setAttribute("cart",bookMap);
						testing = true;
					}
				} 
				/*BOOK DOESNT EXIST YET, ADD TO CART*/
				if(testing == false) {
				updateCart = (HashMap<Book,Integer>)sess.getAttribute("cart");
				
				updateCart.put(record,1);
				sess.setAttribute("cartQuantity",updateCart.size());

				sess.setAttribute("cart",updateCart);
				}
			}
			/*redirect back to the main page*/

			response.sendRedirect("index.jsp");

			}catch(Exception e) {System.out.println("Error: "+e);}
			
		}
		/*if action is remove button then */
		/*use counter that corresponds to the item in html to iterate thourhg the hashmap and delete the corresponding one*/
		else if(action.equals("deletenow")) {
			int counter =0;
			updateCart = (HashMap<Book,Integer>)sess.getAttribute("cart");
			String getIndex = request.getParameter("index");
			for(HashMap.Entry<Book,Integer> entry: updateCart.entrySet()) {
				if(getIndex.equals(String.valueOf(counter))) {
					if(entry.getValue()==1) {
						updateCart.remove(entry.getKey());
						sess.setAttribute("cart",updateCart);
						break;
					}
					else {
						updateCart.put(entry.getKey(),entry.getValue()-1);
						sess.setAttribute("cart",updateCart);
						break;
						}
				}
				counter++;
			}
			sess.setAttribute("cartQuantity",updateCart.size());

			response.sendRedirect("Cart.jsp");
			
		}
		
    }
}
