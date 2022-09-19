package com.gocheeta.web.model;

public class Login {

	private int cId;
	private String fullName;
	private String contactNo;
	private String email;
	protected String password;
	private String userName;
	
	public Login() {
		
	}

	public Login(String userName) {
		
		this.userName = userName;
	}

	public Login(String password, String userName) {
		
		this.password = password;
		this.userName = userName;
	}

	public Login(int cId, String fullName, String contactNo, String email, String password, String userName) {
		
		this.cId = cId;
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
