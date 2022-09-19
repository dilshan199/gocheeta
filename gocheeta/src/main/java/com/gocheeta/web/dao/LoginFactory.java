package com.gocheeta.web.dao;

public class LoginFactory {
	public static LoginManager loginManagerIns() {
		return new LoginManagerImpl();
	}
}
