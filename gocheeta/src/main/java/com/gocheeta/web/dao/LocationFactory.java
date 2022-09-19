package com.gocheeta.web.dao;

public class LocationFactory {
	public static LocationManager locationManagerIns() {
		return new LocationManagerImpl();
	}
}
