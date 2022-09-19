package com.gocheeta.web.dao;

public class VehiclesFactory {
	public static VehiclesManager vehiclesManagerIns() {
		return new VehiclesManagerImpl();
	}
}
