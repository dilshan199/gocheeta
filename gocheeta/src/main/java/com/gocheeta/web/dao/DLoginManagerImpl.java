package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gocheeta.web.model.DLogin;

public class DLoginManagerImpl implements DLoginManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public boolean checkExitUser(String nic) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT nic FROM driver WHERE nic = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, nic);
		ResultSet rst = ps.executeQuery();
		boolean userExit = false;
		if(rst.next()) {
			userExit = true;
		}
		ps.close();
		conn.close();
		
		return userExit;
	}

	@Override
	public boolean validatePassword(String nic, String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT nic,password FROM driver WHERE nic = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, nic);
		ps.setString(2, password);
		ResultSet rst = ps.executeQuery();
		boolean validPassword = false;
		if(rst.next()) {
			validPassword = true;
		}
		ps.close();
		conn.close();
		
		return validPassword;
	}

	@Override
	public DLogin getUser(String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM driver WHERE password = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, password);
		ResultSet rst = ps.executeQuery();
		DLogin login = new DLogin();
		while(rst.next()) {
			login.setDriverId(rst.getInt("driverId"));
			login.setFirstName(rst.getString("firstName"));
			login.setLastName(rst.getString("lastName"));
			login.setNic(rst.getString("nic"));
			login.setPassword(rst.getString("password"));
			login.setContactNo(rst.getString("contactNo"));
		}
		ps.close();
		conn.close();
		
		return login;
	}

}
