package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.FeedbackFactory;
import com.gocheeta.web.dao.FeedbackManager;
import com.gocheeta.web.model.Feedback;

@SuppressWarnings("unused")
public class FeedbackServices {

	private static FeedbackServices feedbackServicesObj;
	
	private FeedbackServices() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized FeedbackServices feedbackServicesIns() {
		if(feedbackServicesObj == null) {
			feedbackServicesObj = new FeedbackServices();
		}
		
		return feedbackServicesObj;
	}
	
	//Add rows
	public boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		FeedbackManager fm = FeedbackFactory.feedbackIns();
		
		return fm.addFeedback(feedback);
	}
	
	//Update feedback status when customer write feedback each juorny
	public boolean updateStatus(int bookingId) throws ClassNotFoundException, SQLException {
		FeedbackManager fm = FeedbackFactory.feedbackIns();
		
		return fm.updateStatus(bookingId);
	}
	
	//Get booking id
	public Feedback getBookingId(int bookingId) throws ClassNotFoundException, SQLException {
		FeedbackManager fm = FeedbackFactory.feedbackIns();
		
		return fm.getBookingId(bookingId);
	}
}
