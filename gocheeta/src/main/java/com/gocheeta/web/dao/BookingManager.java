package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.Booking;

public interface BookingManager {
	public List<Booking> branches() throws ClassNotFoundException, SQLException;
	public boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException;
	public Booking getVehicle(int vehicleId) throws ClassNotFoundException, SQLException;
}
