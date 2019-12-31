package cit285.book.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.book.domain.User;

public class UserDao {
		public ArrayList<User> getUserInfo(){
			ArrayList<User> userList = new ArrayList<User>();
			
			try {
				Connection connection = ConnectionDao.getSQLConnection();
				User user;
				Statement prepareQuery = connection.createStatement();
				ResultSet resultset  = prepareQuery.executeQuery("select u.UserID, Password, FirstName, LastName,CompanyName,Address1,Address2,City,State,"
						+ "Zip,Country,EmailAddress from User u inner join "
						+ "Address a on u.UserID = a.UserID inner join Email e on u.UserID = e.UserID;");
				
				//iterate through result set and add information to the users
				//add to the list
				while(resultset.next())
				{
					System.out.println("UserDao.java- users"+resultset.getString(1));

					user = new User(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6),resultset.getString(7),resultset.getString(8),
							resultset.getString(9),resultset.getString(10),resultset.getString(11),resultset.getString(12));
					userList.add(user);
				}
				resultset = prepareQuery.executeQuery("select UserID, Password, FirstName, LastName, CompanyName from User where Type ='2';");
				while(resultset.next()) {
					System.out.println("UserDao.java- users"+resultset.getString(1));
					user = new User(resultset.getString(1),resultset.getString(2),resultset.getString(3),
							resultset.getString(4),resultset.getString(5));
					userList.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userList;
			
			
		}

}
