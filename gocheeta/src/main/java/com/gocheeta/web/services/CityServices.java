package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.CityFactory;
import com.gocheeta.web.dao.CityManager;
import com.gocheeta.web.model.City;

@SuppressWarnings("unused")
public class CityServices {

	private static CityServices cityServicesObj; 
	
	private CityServices() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized CityServices cityServicesIns() {
		if(cityServicesObj == null) {
			cityServicesObj = new CityServices();
		}
		
		return cityServicesObj;
	}
	
	public List<City> getCities(int branchId) throws ClassNotFoundException, SQLException{
		CityManager cm = CityFactory.cityManagerIns();
		
		return cm.getCities(branchId);
	}

}
