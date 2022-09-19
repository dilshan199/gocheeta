package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.Location;

public class LocationManagerImpl implements LocationManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<Location> getStreets(int branchId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT street FROM distination WHERE branchId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(branchId, branchId);
		ResultSet rst = ps.executeQuery();
		List<Location> streetList = new ArrayList<Location>();
		while(rst.next()) {
			Location location = new Location();
			location.setStreet(rst.getString("street"));
			streetList.add(location);
		}
		ps.close();
		conn.close();
		
		return streetList;
	}

}
