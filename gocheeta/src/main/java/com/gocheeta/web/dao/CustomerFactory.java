package com.gocheeta.web.dao;

public class CustomerFactory {
	public static CustomerManager customerManagerIns() {
		return new CustomerManagerImpl();
	}
}
