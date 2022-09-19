package com.gocheeta.web.dao;

import java.sql.SQLException;

import com.gocheeta.web.model.Login;

public interface LoginManager {
	public boolean checkExitUser(String userName) throws ClassNotFoundException, SQLException;
	public boolean passwordValidation(String userName, String password) throws ClassNotFoundException, SQLException;
	public Login getUser(String password) throws ClassNotFoundException, SQLException;
}
