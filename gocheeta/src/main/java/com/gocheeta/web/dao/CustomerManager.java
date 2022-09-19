package com.gocheeta.web.dao;

import java.sql.SQLException;

import com.gocheeta.web.model.Customer;

public interface CustomerManager {
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	public boolean exitUser(String userName) throws ClassNotFoundException, SQLException;
}
