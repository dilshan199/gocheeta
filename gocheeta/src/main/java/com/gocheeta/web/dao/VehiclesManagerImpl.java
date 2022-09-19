package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.Vehicle;

public class VehiclesManagerImpl implements VehiclesManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}

	@Override
	public List<Vehicle> getVehicles(int catId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM vehicle INNER JOIN category USING(catId) INNER JOIN driver USING(vehicleId) WHERE catId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, catId);
		ResultSet rst = ps.executeQuery();
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		while(rst.next()) {
			Vehicle vehicles = new Vehicle();
			vehicles.setVehicleId(rst.getInt("vehicleId"));
			vehicles.setImage(rst.getString("image"));
			vehicles.setVehicleNo(rst.getString("vehicleNo"));
			vehicles.setVehicleName(rst.getString("vehicleName"));
			vehicles.setMaxPassenger(rst.getInt("maxPassenger"));
			vehicles.setPricePerKm(rst.getDouble("pricePerKm"));
			vehicles.setFirstName(rst.getString("firstName"));
			vehicles.setLastName(rst.getString("lastName"));
			vehicles.setCategory(rst.getString("category"));
			vehicles.setVehicleStatus(rst.getInt("vehicleStatus"));
			
			vehicleList.add(vehicles);
		}
		ps.close();
		conn.close();
		
		return vehicleList;
	}

}
