package com.gocheeta.web.dao;

import java.sql.SQLException;

import com.gocheeta.web.model.Destination;

public interface DestinationManager {
	public Destination getDestination(String street, String city) throws ClassNotFoundException, SQLException;
}
