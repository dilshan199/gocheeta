package com.gocheeta.web.model;

public class Feedback {

	private int cId;
	private int bookingId;
	private String message;
	private int feedbackStatus;
	
	public Feedback() {
		
	}

	public Feedback(int bookingId, int cId, String message) {
		
		this.bookingId = bookingId;
		this.cId = cId;
		this.message = message;
	}
	

	public Feedback(int bookingId, int feedbackStatus) {
		
		this.bookingId = bookingId;
		this.feedbackStatus = feedbackStatus;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(int feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	

}
