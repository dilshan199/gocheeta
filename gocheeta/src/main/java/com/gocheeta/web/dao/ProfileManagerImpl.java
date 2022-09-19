package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.Profile;

public class ProfileManagerImpl implements ProfileManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<Profile> getAllBooking(int cId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM booking INNER JOIN driver USING(driverId) WHERE cId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cId);
		ResultSet rst = ps.executeQuery();
		List<Profile> bookingList = new ArrayList<Profile>();
		while(rst.next()) {
			Profile booking = new Profile();
			booking.setBookingId(rst.getInt("bookingId"));
			booking.setPickUp(rst.getString("pickUp"));
			booking.setDropLocation(rst.getString("dropLocation"));
			booking.setContactNo(rst.getString("contactNo"));
			booking.setBookingStatus(rst.getInt("bookingStatus"));
			booking.setPrice(rst.getDouble("price"));
			booking.setFeedbackStatus(rst.getInt("feedbackStatus"));
			booking.setBookingDate(rst.getString("bookingDate"));
			
			bookingList.add(booking);
		}
		ps.close();
		conn.close();
		
		return bookingList;
	}

}
