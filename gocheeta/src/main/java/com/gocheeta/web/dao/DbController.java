package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbController {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
