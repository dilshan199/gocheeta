package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.City;

public interface CityManager {
	public List<City> getCities(int branchId) throws ClassNotFoundException, SQLException;
}
