package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gocheeta.web.model.Feedback;

public class FeedbackManagerImpl implements FeedbackManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	public boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "INSERT INTO feedback (cId,message,bookingId) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, feedback.getcId());
		ps.setString(2, feedback.getMessage());
		ps.setInt(3, feedback.getBookingId());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public boolean updateStatus(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "UPDATE booking SET feedbackStatus = 1 WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(bookingId, bookingId);
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		
		return result > 0;
	}

	@Override
	public Feedback getBookingId(int bookingId) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT bookingId FROM booking WHERE bookingId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(bookingId, bookingId);
		ResultSet rst = ps.executeQuery();
		Feedback feedback = new Feedback();
		while(rst.next()) {
			feedback.setBookingId(rst.getInt("bookingId"));
		}
		ps.close();
		conn.close();
		
		return feedback;
	}
}
