package com.gocheeta.web.model;

public class Customer {

	private int cId;
	private String fullName;
	private String contactNo;
	private String email;
	protected String password;
	private String userName;
	
	public Customer() {
		
	}
	
	

	public Customer(String userName) {
		
		this.userName = userName;
	}



	public Customer(String fullName, String contactNo, String email, String password, String userName) {
		
		this.fullName = fullName;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
