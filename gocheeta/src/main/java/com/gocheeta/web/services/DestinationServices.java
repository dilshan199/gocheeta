package com.gocheeta.web.services;

import java.sql.SQLException;

import com.gocheeta.web.dao.DestinationFactory;
import com.gocheeta.web.dao.DestinationManager;
import com.gocheeta.web.model.Destination;

public class DestinationServices {

	private static DestinationServices destinationServicesObj;
	
	private DestinationServices() {
		
	}
	
	public static synchronized DestinationServices destinationServicesIns() {
		if(destinationServicesObj == null) {
			destinationServicesObj = new DestinationServices();
		}
		return destinationServicesObj;
	}
	
	public Destination getDestination(String street, String city) throws ClassNotFoundException, SQLException {
		DestinationManager dm = DestinationFactory.destinationManagerIns();
		
		return dm.getDestination(street, city);
	}

}
