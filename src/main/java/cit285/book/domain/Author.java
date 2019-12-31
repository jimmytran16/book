package cit285.book.domain;

import java.io.Serializable;

public class Author implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int authorid=0;
	private String authorfirstname="";
	private String authorlastname="";
	
	// Set author id
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	// Get author id
	public int getAuthorid() {
		return authorid;
	}
	
	// Set author fist name
	public void setAuthorfirstname(String firstname) {
		authorfirstname = firstname;
	}
	
	// Get author first name
	public String getAuthorfirstname() {
		return authorfirstname;
	}
	
	// Set author last name
	public void setAuthorlastname(String lastname) {
		authorlastname = lastname;
	}
	
	// Get author last name
	public String getAuthorlastname() {
		return authorlastname;
	}
}
