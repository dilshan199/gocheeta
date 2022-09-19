package com.gocheeta.web.services;

import java.sql.SQLException;

import com.gocheeta.web.dao.LoginFactory;
import com.gocheeta.web.dao.LoginManager;
import com.gocheeta.web.model.Login;

public class LoginServices {

	private static LoginServices loginServicesObj;
	
	private LoginServices() {
		
	}
	
	public static synchronized LoginServices loginServicesIns() {
		if(loginServicesObj == null) {
			loginServicesObj = new LoginServices();
		}
		return loginServicesObj;
	}
	
	public boolean checkExitUser(String userName) throws ClassNotFoundException, SQLException {
		LoginManager lm = LoginFactory.loginManagerIns();
		
		return lm.checkExitUser(userName);
	}
	
	public boolean passwordValidation(String userName, String passwird) throws ClassNotFoundException, SQLException {
		LoginManager lm = LoginFactory.loginManagerIns();
				
		return lm.passwordValidation(userName, passwird);
		
	}
	
	public Login getUser(String password) throws ClassNotFoundException, SQLException {
		LoginManager lm = LoginFactory.loginManagerIns();
		
		return lm.getUser(password);
	}

}
