package com.gocheeta.web.model;

public class Destination {

	private String street;
	private String city;
	private double destination;
	
	public Destination() {
		
	}

	public Destination(String street, String city) {
		
		this.street = street;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getDestination() {
		return destination;
	}

	public void setDestination(double destination) {
		this.destination = destination;
	}
	
	

}
