package com.gocheeta.web.model;

public class Profile {

	private int cId;
	private int bookingId;
	private String pickUp;
	private String dropLocation;
	private double price;
	private String bookingDate;
	private String contactNo;
	private int bookingStatus;
	private int feedbackStatus;
	
	public Profile() {
		
	}
	
	

	public Profile(int cId) {
		
		this.cId = cId;
	}



	public Profile(int bookingId, String pickUp, String dropLocation, double price, String bookingDate,
			String contactNo, int bookingStatus, int feedbackStatus) {
		
		this.bookingId = bookingId;
		this.pickUp = pickUp;
		this.dropLocation = dropLocation;
		this.price = price;
		this.bookingDate = bookingDate;
		this.contactNo = contactNo;
		this.bookingStatus = bookingStatus;
		this.feedbackStatus = feedbackStatus;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(int feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	
	

}
