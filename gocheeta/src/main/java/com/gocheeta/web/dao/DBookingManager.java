package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.DBooking;

public interface DBookingManager {
	public List<DBooking> getBooking(int driverId) throws ClassNotFoundException, SQLException;
	public DBooking getSelectedBooking(int bookingId) throws ClassNotFoundException, SQLException;
	public boolean confirmBooking(int bookingId) throws ClassNotFoundException, SQLException;
	public boolean completeBooking(int bookingId) throws ClassNotFoundException, SQLException;
	public boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException;
	public boolean updateVehicle(DBooking dbooking) throws ClassNotFoundException, SQLException;
}
