package cit285.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InvoiceDao {
	public void insertReciept(int INVOICE_NUMBER,String userID, double total, String modifiedDate) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = ConnectionDao.getSQLConnection();
		}catch(Exception e) {}
		PreparedStatement setReciept = connection.prepareStatement("insert into Invoice values(?,?,?,?,?)");
		setReciept.setInt(1,INVOICE_NUMBER);
		setReciept.setString(2, userID);
		setReciept.setString(3, modifiedDate);
		setReciept.setDouble(4, total);
		setReciept.setInt(5,1);
		// Execute statement
		setReciept.executeUpdate();
		connection.close();
	}
}
