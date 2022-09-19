package com.gocheeta.web.dao;

import java.sql.SQLException;

import com.gocheeta.web.model.Feedback;

public interface FeedbackManager {
	public boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException;
	public boolean updateStatus(int bookingId) throws ClassNotFoundException, SQLException;
	public Feedback getBookingId(int bookingId) throws ClassNotFoundException, SQLException;
}
