package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gocheeta.web.model.Customer;

public class CustomerManagerImpl implements CustomerManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "INSERT INTO customer (fullName,contactNo,email,password,userName) VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, customer.getFullName());
		ps.setString(2, customer.getContactNo());
		ps.setString(3, customer.getEmail());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getUserName());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
				
		return result > 0;
	}

	@Override
	public boolean exitUser(String userName) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT userName FROM customer WHERE userName = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rst = ps.executeQuery();
		boolean userFound = false;
		if(rst.next()) {
			userFound = true;
		}
		
		return userFound;
	}

}
