package cit285.book.dao;
import java.sql.*;



public class ConnectionDao {
// Use Heruko database crudentials to connect to JawsDB mySQL
	public static Connection getSQLConnection() throws Exception {
		try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "v95qil3d42zghxfp";
		String password="vdq7mt00lxf89o16";
		String url = "jdbc:mysql://	a07yd3a6okcidwap.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/mah532g37g14szwp";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println("Connected to SQL");
		return conn;
		}catch(Exception e) {System.out.println("Error connecting to Databse! "+e);}
		return null;
	}
	public static void closeConnection(Connection c) throws SQLException {
		c.close();
	}

}
