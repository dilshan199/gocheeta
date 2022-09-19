package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.BookingFactory;
import com.gocheeta.web.dao.BookingManager;
import com.gocheeta.web.model.Booking;

@SuppressWarnings("unused")
public class BookingServices {

	private static BookingServices bookingServicesObj;
	
	private BookingServices() {
		
	}
	
	public static synchronized BookingServices bookingServicesIns() {
		if(bookingServicesObj == null) {
			bookingServicesObj = new BookingServices();
		}
		
		return bookingServicesObj;
	}
	
	//Get all branch rows
	public List<Booking> branches() throws ClassNotFoundException, SQLException{
		BookingManager bm = BookingFactory.bookingManagerIns();
		
		return bm.branches();
	}
	
	//Add Booking
	public boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		BookingManager bm = BookingFactory.bookingManagerIns();
		
		return bm.addBooking(booking);
	}
	
	//Get Selected row
	public Booking getVehicle(int vehicleId) throws ClassNotFoundException, SQLException {
		BookingManager bm = BookingFactory.bookingManagerIns();
		
		return bm.getVehicle(vehicleId);
	}
	

}
