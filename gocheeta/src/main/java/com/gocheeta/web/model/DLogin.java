package com.gocheeta.web.model;

public class DLogin {
	
	private int driverId;
	private String firstName;
	private String lastName;
	private String nic;
	private String password;
	private String contactNo;
	
	public DLogin() {
		
	}

	public DLogin(String nic) {
		
		this.nic = nic;
	}

	public DLogin(int driverId, String firstName, String lastName, String nic, String password, String contactNo) {
		
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.password = password;
		this.contactNo = contactNo;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	

}
