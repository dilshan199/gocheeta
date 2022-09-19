package com.gocheeta.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gocheeta.web.model.Home;

public class HomeManagerImpl implements HomeManager{

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbController sqlConnector = new SqlDbController();
		return sqlConnector.getConnection();
	}
	
	@Override
	public List<Home> getCategory() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM category";
		Statement stmt = conn.createStatement();
		ResultSet rst = stmt.executeQuery(sql);
		List<Home> categoryList = new ArrayList<Home>();
		while(rst.next()) {
			Home category = new Home();
			category.setCatId(rst.getInt("catId"));
			category.setCategory(rst.getString("category"));
			categoryList.add(category);
		}
		stmt.close();
		conn.close();
		
		return categoryList;
	}

	@Override
	public List<Home> feedback() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM feedback INNER JOIN customer USING(cId) INNER JOIN booking USING(bookingId)";
		Statement stmt = conn.createStatement();
		ResultSet rst = stmt.executeQuery(sql);
		List<Home> feedbackList = new ArrayList<Home>();
		while(rst.next()) {
			Home feedback = new Home();
			feedback.setFullName(rst.getString("fullName"));
			feedback.setPickUp(rst.getString("pickUp"));
			feedback.setDropLocation(rst.getString("dropLocation"));
			feedback.setMessage(rst.getString("message"));
			feedbackList.add(feedback);
		}
		stmt.close();
		conn.close();
		
		return feedbackList;
	}

}
