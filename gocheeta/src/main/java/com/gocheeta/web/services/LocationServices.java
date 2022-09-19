package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.LocationFactory;
import com.gocheeta.web.dao.LocationManager;
import com.gocheeta.web.model.Location;

@SuppressWarnings("unused")
public class LocationServices {

	private static LocationServices locationServicesObj;
	
	private LocationServices() {
		
	}
	
	public static LocationServices locationServicesIns() {
		if(locationServicesObj == null) {
			locationServicesObj = new LocationServices();
		}
		
		return locationServicesObj;
	}
	
	//Get All street related branchId
	public List<Location> getStreets(int branchId) throws ClassNotFoundException, SQLException{
		LocationManager lm = LocationFactory.locationManagerIns();
		
		return lm.getStreets(branchId);
	}

}
