package cit285.book.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.dao.InvoiceDao;
import cit285.book.domain.Book;
import cit285.book.domain.Cart;

@WebServlet("/addReciept")

public class AddRecieptServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5461885266301899863L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException
    {             
		double total = Cart.getTotal();

        if(total==0.0) {
    		request.getRequestDispatcher("WEB-INF/process/Cart.jsp").forward(request, response);
        }
        else {
        	InvoiceDao invoiceDao = new InvoiceDao();
            HttpSession session = request.getSession();
            HashMap<Book,Integer> invoiceMap;
       	 	ThreadLocalRandom random = ThreadLocalRandom.current();
       	 	long l = random.nextLong(10_000_000_000L, 100_000_000_000L);
       	 	int INVOICE_NUMBER = (int) l;
		/*Get the current date of payment proccess*/
       	 	Date date = new Date();

       	 	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        	/*Get the session to get USERID and to get the CART*/
    		String userID = (String )session.getAttribute("userID");
    		Cart showCart = (Cart)session.getAttribute("bookcart");
            try {
    			invoiceDao.insertReciept(INVOICE_NUMBER,userID,total,modifiedDate);
    			invoiceMap = new HashMap<>(Cart.getCart());
    			showCart.clearCart();
    			session.setAttribute("invoiceDate",modifiedDate);
    			session.setAttribute("invoiceNumber",INVOICE_NUMBER);
    			session.setAttribute("bookcart",showCart);
    			session.setAttribute("total",total);
    			session.setAttribute("invoiceMap",invoiceMap);
    			System.out.println("Insert reciept successful!");
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            //redirect back to cart
    		request.getRequestDispatcher("WEB-INF/process/invoice.jsp").forward(request, response);
                	
        }
    }
}
