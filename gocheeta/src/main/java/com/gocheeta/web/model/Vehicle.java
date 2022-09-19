package com.gocheeta.web.model;

public class Vehicle {

	private int catId;
	private String category;
	private int vehicleId;
		private String image;
		private String vehicleNo;
		private String vehicleName;
		private int maxPassenger;
		private double pricePerKm;
		private int driverId;
		private String firstName;
		private String lastName;
		private int vehicleStatus;
		
		public Vehicle() {
			
		}

		public Vehicle(int catId) {
		
			this.catId = catId;
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

		public int getVehicleId() {
			return vehicleId;
		}

		public void setVehicleId(int vehicleId) {
			this.vehicleId = vehicleId;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
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

		public int getMaxPassenger() {
			return maxPassenger;
		}

		public void setMaxPassenger(int maxPassenger) {
			this.maxPassenger = maxPassenger;
		}

		public double getPricePerKm() {
			return pricePerKm;
		}

		public void setPricePerKm(double pricePerKm) {
			this.pricePerKm = pricePerKm;
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

		public int getVehicleStatus() {
			return vehicleStatus;
		}

		public void setVehicleStatus(int vehicleStatus) {
			this.vehicleStatus = vehicleStatus;
		}
}
