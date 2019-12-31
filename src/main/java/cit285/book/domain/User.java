package cit285.book.domain;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private String password;
	private String first_name;
	private String last_name;
	private String company_name;
	private String address_one;
	private String address_two;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String email_address;
	public boolean type;
	
	//contructor for Admin
	public User(String userid,String password,String first_name, String last_name,String company_name) {
		this.userid =userid;
		this.password =password;
		this.first_name =first_name;
		this.last_name =last_name;
		this.company_name =company_name;
		this.type=true;
	}
	
	//contructor for User
	public User(String userid,String password,String first_name,String 
			last_name, String company_name,String address_one,String address_two,
			String city,String state,String zip,String country,String email_address){
		this.userid =userid;
		this.password =password;
		this.first_name =first_name;
		this.last_name =last_name;
		this.company_name =company_name;
		this.address_one =address_one;
		this.address_two =address_two;
		this.city =city;
		this.state =state;
		this.zip = zip;
		this.country=country;
		this.email_address = email_address;
		this.type =false;
	}
	
	public String getUserID() {
		return userid;
	}
	
	public String getPassword() {
		return password;
	}	
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getCompanyName() {
		return company_name;
		
	}
	
	public String getAddressOne() {
		return address_one;
	}
	
	public String getAddressTwo() {
		return address_two;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getEmailAddress() {
		return email_address;
	}
}
