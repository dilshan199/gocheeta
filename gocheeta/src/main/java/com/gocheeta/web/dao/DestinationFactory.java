package com.gocheeta.web.dao;

public class DestinationFactory {
	public static DestinationManager destinationManagerIns() {
		return new DestinationManagerImpl();
	}
}
