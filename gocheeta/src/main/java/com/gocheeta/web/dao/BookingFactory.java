package com.gocheeta.web.dao;

public class BookingFactory {
	public static BookingManager bookingManagerIns() {
		return new BookingManagerImpl();
	}
}
