package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.Location;

public interface LocationManager {
	public List<Location> getStreets(int branchId) throws ClassNotFoundException, SQLException;
}
