package com.gocheeta.web.model;

public class City {

	private int branchId;
	private String city;
	
	public City() {
		
	}

	public City(int branchId, String city) {
		
		this.branchId = branchId;
		this.city = city;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
