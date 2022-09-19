package com.gocheeta.web.model;

public class Booking {
	
	private int branchId;
	private String pickUp;
	private String dropLocation;
	private String pickUpDate;
	private int cId;
	private double pricePerKm;
	private double destination;
	private double price;
	private int vehicleId;
	private int driverId;
	private String branchName;
	private int maxPassenger;
	private String firstName;
	private String lastName;
	private String vehicleNo;
	private String vehicleName;
	private String image;

	public Booking() {
		
	}

	public Booking(int branchId, String branchName) {
		
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public Booking(int branchId, int vehicleId, int driverId, int cId, String pickUp, String dropLocation,
			String pickUpDate, double price) {
		
		this.branchId = branchId;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.cId = cId;
		this.pickUp = pickUp;
		this.dropLocation = dropLocation;
		this.pickUpDate = pickUpDate;
		this.price = price;
	}

	public Booking(double pricePerKm, double destination, int vehicleId, int driverId, int maxPassenger,
			String firstName, String lastName, String vehicleNo, String vehicleName, String image) {
		
		this.pricePerKm = pricePerKm;
		this.destination = destination;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.maxPassenger = maxPassenger;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.image = image;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public double getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(double pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	public double getDestination() {
		return destination;
	}

	public void setDestination(double destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getMaxPassenger() {
		return maxPassenger;
	}

	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
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

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
