package com.gocheeta.web.dao;

import java.sql.SQLException;

import com.gocheeta.web.model.DLogin;

public interface DLoginManager {
	public boolean checkExitUser(String nic) throws ClassNotFoundException, SQLException;
	public boolean validatePassword(String nic, String password) throws ClassNotFoundException, SQLException;
	public DLogin getUser(String password) throws ClassNotFoundException, SQLException;
}
