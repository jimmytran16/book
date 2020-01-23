package cit285.book.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.book.domain.Author;
import cit285.book.domain.Book;

public class BookDao {

	public ArrayList<Book> getBooks() throws SQLException, ClassNotFoundException {
		ArrayList<Book> booksList = new ArrayList<>();

		Connection connection = null;	
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Book");

		// Create prepared statement to get Author.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");

		// Iterate through the result and print
		while (resultSet.next()) {
			Book book = new Book();
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			book.setImage(resultSet.getString(7));
			book.setPrice(resultSet.getDouble(8));
			// Get the author for this book
			preparedStatement.setInt(1, resultSet.getInt(9));
			ResultSet rset = preparedStatement.executeQuery();
			if (rset.next()) {
				Author author = new Author();

				author.setAuthorid(rset.getInt(1));
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
				book.setAuthor(author);
			}

			booksList.add(book);
		}
		connection.close();
		preparedStatement.close();
		resultSet.close();
		return booksList;
	}

	public void setBook(Book book) throws SQLException, ClassNotFoundException {

		Connection connection = null;
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Create statement
		PreparedStatement setBook = connection.prepareStatement("insert into Book values(?,?,?,?,?,?,?,?,?)");

		// Set data to table author
		setBook.setInt(1, book.getBookid());
		setBook.setString(2, book.getIsbn());
		setBook.setString(3, book.getTitle());
		setBook.setString(4, book.getEditor());
		setBook.setString(5, book.getEdition());
		setBook.setInt(6, book.getYear());
		setBook.setString(7,book.getImage());
		setBook.setDouble(9, book.getPrice());
		setBook.setInt(8, book.getAuthor().getAuthorid());

		// Execute statement
		setBook.executeUpdate();
		//close connection
		connection.close();

	}

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {

		Connection connection = null;
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Create statement
		PreparedStatement updateBook = connection.prepareStatement("update Book "
				+ "set ISBN = ?, Title = ?, Editor = ?, Edition = ?, Year = ?, Image = ?, Price = ?, AuthorID = ? "
				+ "where BookID = ?");

		// Set data to table author
		updateBook.setString(1, book.getIsbn());
		updateBook.setString(2, book.getTitle());
		updateBook.setString(3, book.getEditor());
		updateBook.setString(4, book.getEdition());
		updateBook.setInt(5, book.getYear());
		// Set image
				String filename = book.getImage();
				File image = new File(filename);
				FileInputStream fis;
				try {
					fis = new FileInputStream(image);
					updateBook.setBinaryStream(6, fis, (int) image.length());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		updateBook.setDouble(7, book.getPrice());
		updateBook.setInt(8, book.getAuthor().getAuthorid());
		updateBook.setInt(9, book.getBookid());

		// Execute statement
		updateBook.executeUpdate();
		connection.close();

	}

	public void deleteBook(int bookID) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Create statement
		Statement firstStmt = connection.createStatement();
		firstStmt.executeQuery("SET foreign_key_checks = 0");

		PreparedStatement deleteBook = connection.prepareStatement("delete from Book where bookID = ?");
		deleteBook.setInt(1, bookID);

		deleteBook.execute();

		Statement secondStmt = connection.createStatement();
		secondStmt.executeQuery("SET foreign_key_checks = 1");
		connection.close();

	}

	public Book getBookWithID(int id) throws SQLException, ClassNotFoundException {
		Book book = new Book();
		Author author = new Author();

		Connection connection = null;
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Create statement
		PreparedStatement preparedStatementBook = connection.prepareStatement("select * from Book where BookID=?");
		preparedStatementBook.setInt(1, id);
		ResultSet resultSet = preparedStatementBook.executeQuery();

		// Iterate through the result and print
		while (resultSet.next()) {
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			book.setImage(resultSet.getString(7));
			book.setPrice(resultSet.getDouble(9));
			PreparedStatement preparedStatementAuthor = connection
					.prepareStatement("select * from Author where AuthorID=?");
			preparedStatementAuthor.setInt(1, resultSet.getInt(8));
			ResultSet resultAuthor = preparedStatementAuthor.executeQuery();
			while (resultAuthor.next()) {
				author.setAuthorid(Integer.parseInt(resultAuthor.getString(1)));
				author.setAuthorfirstname(resultAuthor.getString(2));
				author.setAuthorlastname(resultAuthor.getString(3));
			}
			book.setAuthor(author);
		}
		connection.close();
		return book;
	}

	public ResultSet getImageByBookID(int bookID) throws SQLException, ClassNotFoundException {

		Connection connection = null;
		try {
			connection = ConnectionDao.getSQLConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		// Create statement
		PreparedStatement preparedStatementBook = connection.prepareStatement("select image from Book where BookID=?");
		preparedStatementBook.setInt(1, bookID);
		ResultSet resultSet = preparedStatementBook.executeQuery();
		connection.close();
		return resultSet;
	}

}
