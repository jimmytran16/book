package cit285.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.book.domain.Author;

public class AuthorDao {

	public ArrayList<Author> getAuthor() throws Exception {
		ArrayList<Author> authors = new ArrayList<>();		

		Connection connection = ConnectionDao.getSQLConnection();
		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Author");

		while (resultSet.next()) {
			Author author = new Author();
			author.setAuthorid(Integer.parseInt(resultSet.getString(1)));
			author.setAuthorfirstname(resultSet.getString(2));
			author.setAuthorlastname(resultSet.getString(3));
			authors.add(author);
		}

		return authors;
	}

	public String getAuthorID(String firstName, String lastName) throws Exception {
		String authorID = "";

		Connection connection = ConnectionDao.getSQLConnection();
		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		ResultSet resultSet = statement.executeQuery("select AuthorID from Author where " + "AuthorFirstName = '"
				+ firstName + "'" + " and AuthorLastName = '" + lastName + "'");
		while (resultSet.next()) {
			authorID = resultSet.getString(1);
			System.out.println(authorID);
		}
		

		return authorID;
	}

	public void setAuthor(Author author) throws Exception {
	
		Connection connection = ConnectionDao.getSQLConnection();
		// Create statement
		PreparedStatement setAuthor = connection.prepareStatement("insert into Author values(?,?,?)");

		// Set data to table author
		setAuthor.setInt(1, author.getAuthorid());
		setAuthor.setString(2, author.getAuthorfirstname());
		setAuthor.setString(3, author.getAuthorlastname());

		// Execute statement
		setAuthor.executeUpdate();

	}
}
