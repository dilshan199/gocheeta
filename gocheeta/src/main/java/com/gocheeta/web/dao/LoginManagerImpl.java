package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gocheeta.web.model.Login;

public class LoginManagerImpl implements LoginManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public boolean checkExitUser(String userName) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT userName FROM customer WHERE userName = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rst = ps.executeQuery();
		boolean userFound = false;
		if(rst.next()) {
			userFound = true;
		}
		ps.close();
		conn.close();
		
		return userFound;
	}

	@Override
	public boolean passwordValidation(String userName, String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT userName,password FROM customer WHERE userName = ?  AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rst = ps.executeQuery();
		boolean passwordValid = false;
		if(rst.next()) {
			passwordValid = true;
		}
		ps.close();
		conn.close();
		
		return passwordValid;
	}

	@Override
	public Login getUser(String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM customer WHERE password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ResultSet rst = ps.executeQuery();
		Login login = new Login();
		while(rst.next()) {
			login.setcId(rst.getInt("cId"));
			login.setFullName(rst.getString("fullName"));
			login.setContactNo(rst.getString("contactNo"));
			login.setEmail(rst.getString("email"));
			login.setPassword(rst.getString("password"));
			login.setUserName(rst.getString("userName"));
		}
		ps.close();
		conn.close();
		
		return login;
	}

}
