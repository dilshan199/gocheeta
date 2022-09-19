package com.gocheeta.web.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.dao.DBookingFactory;
import com.gocheeta.web.dao.DBookingManager;
import com.gocheeta.web.model.DBooking;

@SuppressWarnings("unused")
public class DBookingServices {

	private static DBookingServices dBookingServicesObj;
	
	private DBookingServices() {
		
	}
	
	public static synchronized DBookingServices dBookingServicesIns() {
		if(dBookingServicesObj == null) {
			dBookingServicesObj = new DBookingServices();
		}
		return dBookingServicesObj;
	}
	
	public List<DBooking> getBooking(int driverId) throws ClassNotFoundException, SQLException{
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.getBooking(driverId);
	}
	
	public DBooking getSelectedBooking(int bookingId) throws ClassNotFoundException, SQLException {
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.getSelectedBooking(bookingId);
	}
	
	public boolean confirmBooking(int bookingId) throws ClassNotFoundException, SQLException {
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.confirmBooking(bookingId);
	}
	
	public boolean completeBooking(int bookingId) throws ClassNotFoundException, SQLException {
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.completeBooking(bookingId);
	}
	
	public boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException {
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.cancelBooking(bookingId);
	}
	
	public boolean updateVehicle(DBooking dbooking) throws ClassNotFoundException, SQLException {
		DBookingManager dbm = DBookingFactory.dbookingManagerIns();
		
		return dbm.updateVehicle(dbooking);
	}

}
