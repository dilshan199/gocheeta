package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.City;

public class CityManagerImpl implements CityManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<City> getCities(int branchId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM distination WHERE branchId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, branchId);
		ResultSet rst = ps.executeQuery();
		List<City> cityList = new ArrayList<City>();
		while(rst.next()) {
			City city = new City();
			city.setBranchId(rst.getInt("branchId"));
			city.setCity(rst.getString("city"));
			
			cityList.add(city);
		}
		ps.close();
		conn.close();
		
		return cityList;
	}

}
