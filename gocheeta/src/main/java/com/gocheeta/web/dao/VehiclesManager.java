package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.Vehicle;


public interface VehiclesManager {
	public List<Vehicle> getVehicles(int catId) throws ClassNotFoundException, SQLException;
}
