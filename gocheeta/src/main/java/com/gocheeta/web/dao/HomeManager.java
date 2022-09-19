package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.Home;

public interface HomeManager {
	public List<Home> getCategory() throws ClassNotFoundException, SQLException;
	public List<Home> feedback() throws ClassNotFoundException, SQLException;
}
