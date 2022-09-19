package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.ProfileFactory;
import com.gocheeta.web.dao.ProfileManager;
import com.gocheeta.web.model.Profile;

@SuppressWarnings("unused")
public class ProfileServices {

	private static ProfileServices profileServicesObj;
	
	private ProfileServices() {
		
	}
	
	public static synchronized ProfileServices profileServicesIns() {
		if(profileServicesObj == null) {
			profileServicesObj = new ProfileServices();
		}
		return profileServicesObj;
	}
	
	public List<Profile> getAllBooking(int cId) throws ClassNotFoundException, SQLException{
		ProfileManager pm = ProfileFactory.profileManagerIns();
		
		return pm.getAllBooking(cId);
	}

}
