package cit285.book;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;	

import org.junit.Test;

import cit285.book.dao.BookDao;
import cit285.book.dao.UserDao;
import cit285.book.domain.Book;
import cit285.book.domain.User;

public class AppUnitTest{
	//Check if getting book with ID function works
	@Test
	public void TestingGetBookWithID() throws ClassNotFoundException, SQLException {
		BookDao test = new BookDao();
		Book bookOutput = new Book();
		bookOutput = test.getBookWithID(117);
		String testTitle= bookOutput.getTitle();
		String testEditor = bookOutput.getEditor();
		String testEdition = bookOutput.getEdition();
		int testYear = bookOutput.getYear();
		assertEquals("Introduction to Java",testTitle);
		assertEquals("Daniel Liang",testEditor);
		assertEquals("11",testEdition);
		assertEquals(2008,testYear);
	}
	//Check if book inventory is the correct amount
	@Test
	public void TestingBookInventorySize() throws ClassNotFoundException, SQLException {
		BookDao test = new BookDao();
		ArrayList<Book> bookListTest= new ArrayList<Book>(test.getBooks());
		assertEquals(8,bookListTest.size());
	}
	//Check if existing admin is retrieved from database
	@Test
	public void TestAdminRetrieval() throws ClassNotFoundException, SQLException{
		UserDao userTest = new UserDao();
		ArrayList<User> userList = new ArrayList<User>(userTest.getUserInfo());
		Set<String> usernameSet = new HashSet<String>();
		String record = "";
		for(int x =0;x<userList.size();x++) {
			record =userList.get(x).getUserID();
			if(record.equals("jimmytran16")) {
				usernameSet.add(record);
			}
		}
		assertEquals(true,usernameSet.contains("jimmytran16"));
		
	}
	
}
