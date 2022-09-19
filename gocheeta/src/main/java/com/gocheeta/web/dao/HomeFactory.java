package com.gocheeta.web.dao;

public class HomeFactory {
	public static HomeManager homeManagerIns() {
		return new HomeManagerImpl();
	}
}
