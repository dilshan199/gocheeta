package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gocheeta.web.model.Location;
import com.gocheeta.web.services.LocationServices;
import com.google.gson.Gson;

/**
 * Servlet implementation class LocationServlet
 */
public class LocationServlet extends HttpServlet {
	
	LocationServices services;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet() {
        services = LocationServices.locationServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Location location = new Location();
		String op = request.getParameter("operation");
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		List<Location> streetList;
		try {
			streetList = services.getStreets(branchId);
			Gson json = new Gson();
			String sl = json.toJson(streetList);
			response.setContentType("text/html");
			response.getWriter().write(sl);
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
