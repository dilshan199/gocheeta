package com.gocheeta.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.gocheeta.web.model.Profile;

public interface ProfileManager {
	public List<Profile> getAllBooking(int cId) throws ClassNotFoundException, SQLException;
}
