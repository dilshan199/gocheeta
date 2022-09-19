package com.gocheeta.web.dao;

public class DLoginFactory {
	public static DLoginManager dLoginManagerIns() {
		return new DLoginManagerImpl();
	}
}
