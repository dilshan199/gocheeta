package com.gocheeta.web.model;

public class Location {
	
	private int branchId;
	private String street;
	
	public Location() {
		
	}

	public Location(int branchId) {
		
		this.branchId = branchId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	

}
