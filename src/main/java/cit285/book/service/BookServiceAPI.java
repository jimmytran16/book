package cit285.book.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import cit285.book.domain.Book;

public interface BookServiceAPI {
	public ArrayList<Book> getBooks();
	public void setBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(int BookID);
	public Book getBookWithID(int BookID);
	public ResultSet getImageByBookID(int bookID);
}
