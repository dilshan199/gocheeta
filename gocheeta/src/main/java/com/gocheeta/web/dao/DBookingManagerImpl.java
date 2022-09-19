package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.DBooking;

public class DBookingManagerImpl implements DBookingManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<DBooking> getBooking(int driverId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM booking INNER JOIN customer USING(cId) WHERE driverId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, driverId);
		ResultSet rst = ps.executeQuery();
		List<DBooking> bookingList = new ArrayList<DBooking>();
		while(rst.next()) {
			DBooking dbooking = new DBooking();
			dbooking.setBookingId(rst.getInt("bookingId"));
			dbooking.setPickUp(rst.getString("pickUp"));
			dbooking.setDropLocation(rst.getString("dropLocation"));
			dbooking.setPickUpDate(rst.getString("pickUpDate"));
			dbooking.setFullName(rst.getString("fullName"));
			dbooking.setContactNo(rst.getString("contactNo"));
			dbooking.setBookingStatus(rst.getInt("bookingStatus"));
			dbooking.setPrice(rst.getDouble("price"));
			
			bookingList.add(dbooking);
		}
		ps.close();
		conn.close();
		
		return bookingList;
	}

	@Override
	public DBooking getSelectedBooking(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM booking INNER JOIN customer USING(cId) WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bookingId);
		ResultSet rst = ps.executeQuery();
		DBooking dbooking = new DBooking();
		while(rst.next()) {
			dbooking.setBookingId(rst.getInt("bookingId"));
			dbooking.setPickUp(rst.getString("pickUp"));
			dbooking.setDropLocation(rst.getString("dropLocation"));
			dbooking.setPickUpDate(rst.getString("pickUpDate"));
			dbooking.setFullName(rst.getString("fullName"));
			dbooking.setContactNo(rst.getString("contactNo"));
			dbooking.setBookingStatus(rst.getInt("bookingStatus"));
			dbooking.setPrice(rst.getDouble("price"));
			dbooking.setVehicleId(rst.getInt("vehicleId"));
			
		}
		ps.close();
		conn.close();
		
		return dbooking;
	}

	@Override
	public boolean confirmBooking(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "UPDATE booking SET bookingStatus = 1 WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bookingId);
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public boolean completeBooking(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "UPDATE booking SET bookingStatus = 2 WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bookingId);
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "UPDATE booking SET bookingStatus = 3 WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bookingId);
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public boolean updateVehicle(DBooking dbooking) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "UPDATE vehicle SET vehicleStatus = ? WHERE vehicleId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dbooking.getVehicleStatus());
		ps.setInt(2, dbooking.getVehicleId());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}
	

}
