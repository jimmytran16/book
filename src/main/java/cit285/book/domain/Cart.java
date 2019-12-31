package cit285.book.domain;

import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static HashMap<Book,Integer> cartBooks = new HashMap<>();
;
	
	//contructor to make a new cart
	public Cart() {
		
	}
	public void clearCart() {
		cartBooks.clear();
	}
	//add new book to cart
	public void addToCart(Book book, int quantity) {
		cartBooks.put(book,quantity);
	}
	
	//returns a boolean, to determine if book exist or not!
	//if book exist, then we are just updating the quantity
	public boolean checkIfBookExist(int bookid, int quantity) {
		boolean bookExist = false;
		System.out.println(cartBooks);
		for(HashMap.Entry<Book,Integer> entry: cartBooks.entrySet()) {
			if(entry.getKey().getBookid()==bookid) {
				//updates quantity of existing book, if it exists!
				bookExist = true;
				cartBooks.put(entry.getKey(),entry.getValue()+quantity);
			}
		}
		return bookExist;
	}
	

	//delete book in cart map reference by 'bookid'
	public void deleteBookFromCart(int bookid) {
		for(HashMap.Entry<Book,Integer> entry: cartBooks.entrySet()) {
			if(entry.getKey().getBookid()==bookid) {
				if(entry.getValue()==1) {
				cartBooks.remove(entry.getKey());
				break;
				}
				else {
				cartBooks.put(entry.getKey(),entry.getValue()-1);
				break;
				}
			}
		}
	}
	//return subtotal 
	public static double getTotal() {
		double total = 0.0;
		for(HashMap.Entry<Book,Integer> entry: cartBooks.entrySet()) {
			total+=(entry.getKey().getPrice()*entry.getValue());
		}
		return total;
	}
	//return the cart
	public static HashMap<Book,Integer> getCart(){
		return cartBooks;
	}
	//return quantity in cart
	public static int getCartCount() {
		int count = 0;
		for(HashMap.Entry<Book,Integer> entry: cartBooks.entrySet()) {
			count += entry.getValue();
		}
		return count;
	}
	
	
}
