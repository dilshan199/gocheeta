package com.gocheeta.web.model;

public class DBooking {

	private int driverId;
	private int bookingId;
	private int vehicleId;
	private int cId;
	private String fullName;
	private String contactNo;
	private String pickUp;
	private String Location;
	private int bookingStatus;
	private String pickUpDate;
	private String dropLocation;
	private double price;
	private int vehicleStatus;
	
	public DBooking() {
		
	}

	public DBooking(int driverId) {
		
		this.driverId = driverId;
	}
	
	

	public DBooking(int vehicleId, int vehicleStatus) {
		
		this.vehicleId = vehicleId;
		this.vehicleStatus = vehicleStatus;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
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

	public int getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(int vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	
	

}
