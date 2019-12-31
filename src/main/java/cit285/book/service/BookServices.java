package cit285.book.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cit285.book.dao.BookDao;
import cit285.book.domain.Book;

public class BookServices implements BookServiceAPI {
	BookDao bookDao;

	public BookServices() {
		bookDao = new BookDao();
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<>();
		try {
			books = bookDao.getBooks();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public void setBook(Book book) {
		try {
			bookDao.setBook(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBook(int bookID) {
		try {
			bookDao.deleteBook(bookID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Book getBookWithID(int bookID) {
		Book book = new Book();
		try {
			book = bookDao.getBookWithID(bookID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public ResultSet getImageByBookID(int bookID) {
		// TODO Auto-generated method stub
		ResultSet resultSet;
		try {
			resultSet = bookDao.getImageByBookID(bookID);
			return resultSet;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
