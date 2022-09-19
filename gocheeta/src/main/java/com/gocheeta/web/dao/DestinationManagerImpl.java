package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gocheeta.web.model.Destination;

public class DestinationManagerImpl implements DestinationManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public Destination getDestination(String street, String city) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM distination WHERE street = ? AND city = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, street);
		ps.setString(2, city);
		ResultSet rst = ps.executeQuery();
		Destination destination = new Destination();
		while(rst.next()) {
			destination.setDestination(rst.getDouble("distination"));
		}
		ps.close();
		conn.close();
		
		return destination;
	}

}
