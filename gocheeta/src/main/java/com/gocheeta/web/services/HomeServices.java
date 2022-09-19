package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.HomeFactory;
import com.gocheeta.web.dao.HomeManager;
import com.gocheeta.web.model.Home;

@SuppressWarnings("unused")
public class HomeServices {

	private static HomeServices homeServicesObj;
	
	private HomeServices() {
		
	}
	
	public static synchronized HomeServices homeServicesIns() {
		if(homeServicesObj == null) {
			homeServicesObj = new HomeServices();
		}
		return homeServicesObj;
	}
	
	public List<Home> getCategory() throws ClassNotFoundException, SQLException{
		HomeManager hm = HomeFactory.homeManagerIns();
		
		return hm.getCategory();
	}
	
	public List<Home> feedback() throws ClassNotFoundException, SQLException{
		HomeManager hm = HomeFactory.homeManagerIns();
		
		return hm.feedback();
	}

}
