package com.gocheeta.web.services;

import java.sql.SQLException;

import com.gocheeta.web.dao.DLoginFactory;
import com.gocheeta.web.dao.DLoginManager;
import com.gocheeta.web.model.DLogin;

public class DLoginServices {

	private static DLoginServices loginServicesObj;
	
	private DLoginServices() {
		
	}
	
	public static synchronized DLoginServices dLoginServicesIns() {
		if(loginServicesObj == null) {
			loginServicesObj = new DLoginServices();
		}
		return loginServicesObj;
	}
	
	public boolean checkExitUser(String nic) throws ClassNotFoundException, SQLException {
		DLoginManager dlm = DLoginFactory.dLoginManagerIns();
		
		return dlm.checkExitUser(nic);
	}
	
	public boolean validatePassword(String nic, String password) throws ClassNotFoundException, SQLException {
		DLoginManager dlm = DLoginFactory.dLoginManagerIns();
		
		return dlm.validatePassword(nic, password);
	}
	
	public DLogin getUser(String password) throws ClassNotFoundException, SQLException {
		DLoginManager dlm = DLoginFactory.dLoginManagerIns();
		
		return dlm.getUser(password);
	}

}
