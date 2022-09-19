package com.gocheeta.web.dao;

public class ProfileFactory {
	public static ProfileManager profileManagerIns() {
		return new ProfileManagerImpl();
	}
}
