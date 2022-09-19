package com.gocheeta.web.model;

public class Home {

	private int catId;
	private String category;
	private int fbId;
	private String fullName;
	private String message;
	private String pickUp;
	private String dropLocation;
	
	public Home() {
		
	}

	public Home(int catId, String category) {
		
		this.catId = catId;
		this.category = category;
	}

	public Home(String fullName, String message, String pickUp, String dropLocation) {
		
		this.fullName = fullName;
		this.message = message;
		this.pickUp = pickUp;
		this.dropLocation = dropLocation;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getFbId() {
		return fbId;
	}

	public void setFbId(int fbId) {
		this.fbId = fbId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	
	

}
