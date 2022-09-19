package com.gocheeta.web.services;

import java.sql.SQLException;

import com.gocheeta.web.dao.CustomerFactory;
import com.gocheeta.web.dao.CustomerManager;
import com.gocheeta.web.model.Customer;

public class CustomerServices {

	private static CustomerServices customerServicesObj;
	
	private CustomerServices() {
		
	}
	
	public static synchronized CustomerServices customerServicesIns() {
		if(customerServicesObj == null) {
			customerServicesObj = new CustomerServices();
		}
		
		return customerServicesObj;
	}
	
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		CustomerManager cm = CustomerFactory.customerManagerIns();
		
		return cm.addCustomer(customer);
	}
	
	public boolean exitUser(String userName) throws ClassNotFoundException, SQLException {
		CustomerManager cm = CustomerFactory.customerManagerIns();
		
		return cm.exitUser(userName);
	}

}
