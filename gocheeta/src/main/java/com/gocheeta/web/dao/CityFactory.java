package com.gocheeta.web.dao;

public class CityFactory {
	public static CityManager cityManagerIns() {
		return new CityManagerImpl();
	}
}
