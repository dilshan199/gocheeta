package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.Booking;

public class BookingManagerImpl implements BookingManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<Booking> branches() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM branch";
		Statement stmt = conn.createStatement();
		ResultSet rst = stmt.executeQuery(sql);
		List<Booking> branchList = new ArrayList<Booking>();
		while(rst.next()) {
			Booking branch = new Booking();
			branch.setBranchId(rst.getInt("branchId"));
			branch.setBranchName(rst.getString("branchName"));
			
			branchList.add(branch);
		}
		stmt.close();
		conn.close();
		
		return branchList;
	}

	@Override
	public boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "INSERT INTO booking (branchId,vehicleId,driverId,cId,pickUp,dropLocation,pickUpDate,price) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, booking.getBranchId());
		ps.setInt(2, booking.getVehicleId());
		ps.setInt(3, booking.getDriverId());
		ps.setInt(4, booking.getcId());
		ps.setString(5, booking.getPickUp());
		ps.setString(6, booking.getDropLocation());
		ps.setString(7, booking.getPickUpDate());
		ps.setDouble(8, booking.getPrice());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public Booking getVehicle(int vehicleId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM vehicle INNER JOIN driver USING(vehicleId) WHERE vehicleId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, vehicleId);
		ResultSet rst = ps.executeQuery();
		Booking vehicle = new Booking();
		while(rst.next()) {
			vehicle.setVehicleId(rst.getInt("vehicleId"));
			vehicle.setDriverId(rst.getInt("driverId"));
			vehicle.setPricePerKm(rst.getDouble("pricePerKm"));
			vehicle.setFirstName(rst.getString("firstName"));
			vehicle.setLastName(rst.getString("lastName"));
			vehicle.setVehicleNo(rst.getString("vehicleNo"));
			vehicle.setVehicleName(rst.getString("vehicleName"));
			vehicle.setMaxPassenger(rst.getInt("maxPassenger"));
			vehicle.setImage(rst.getString("image"));
		}
		ps.close();
		conn.close();
		
		return vehicle;
	}

}
