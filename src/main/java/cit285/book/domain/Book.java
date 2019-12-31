package cit285.book.domain;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid; // Bood id
	private String isbn; // Book ISBN
	private String title; // Book Title
	private String editor; // Book Editor
	private String edition; // Book Edition
	private int year; // Book Year
	private Author author; // Book Author ID
	private String image; // Book Image
	private double price;
	
	// Set book id
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	// Get book id
	public int getBookid() {
		return bookid;
	}
	
	// Set book Isbn number
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	// Get book Isbn number
	public String getIsbn() {
		return isbn;
	}
	
	// Set book title
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Get book title
	public String getTitle() {
		return title;
	}
	
	// Set book editor
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	// Get book editor
	public String getEditor() {
		return editor;
	}
	
	// Set book edition
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	// Get book edition
	public String getEdition() {
		return edition;
	}
	
	// Set book publication year
	public void setYear(int year) {
		this.year = year;
	}
	
	// Get book publication year
	public int getYear() {
		return year;
	}
	
	// Set book author
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	// Get book author
	public Author getAuthor() {
		return author;
	}
	
	// Set book image
	public void setImage(String image) {
		this.image = image;
	}
	
	// get book image
	public String getImage() {
		return image;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
