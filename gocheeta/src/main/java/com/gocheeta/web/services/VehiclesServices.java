package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.VehiclesFactory;
import com.gocheeta.web.dao.VehiclesManager;
import com.gocheeta.web.model.Vehicle;

@SuppressWarnings("unused")
public class VehiclesServices {

	private static VehiclesServices vehiclesServicesObj;
	
	private VehiclesServices() {
		
	}
	
	public static synchronized VehiclesServices vehiclesServicesIns() {
		if(vehiclesServicesObj == null) {
			vehiclesServicesObj = new VehiclesServices();
		}
		
		return vehiclesServicesObj;
	}
	
	public List<Vehicle> getVehicles(int catId) throws ClassNotFoundException, SQLException{
		VehiclesManager vm = VehiclesFactory.vehiclesManagerIns();
		
		return vm.getVehicles(catId);
	}

}
