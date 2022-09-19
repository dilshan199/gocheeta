package com.gocheeta.web.dao;

public class DBookingFactory {
	public static DBookingManager dbookingManagerIns() {
		return new DBookingManagerImpl();
	}
}
