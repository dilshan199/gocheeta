package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gocheeta.web.model.Vehicle;
import com.gocheeta.web.services.VehiclesServices;

/**
 * Servlet implementation class VehicleServlet
 */
public class VehicleServlet extends HttpServlet {
	
	VehiclesServices services;
	String message;
	int listSize;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleServlet() {
        services = VehiclesServices.vehiclesServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/vehicle":
			getSelectedVehicle(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void getSelectedVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		
		int catId = Integer.parseInt(request.getParameter("catId"));
		List<Vehicle> vehicleList;
		try {
			vehicleList = services.getVehicles(catId);
			listSize = vehicleList.size();
		} catch (ClassNotFoundException | SQLException e) {
			vehicleList = new ArrayList<Vehicle>();
		}
		request.setAttribute("vehicleList", vehicleList);
		request.setAttribute("listSize", listSize);
		RequestDispatcher rd = request.getRequestDispatcher("vehicle.jsp");
		rd.forward(request, response);
	}
	
	public void clearMessage() {
		message = "";
	}

}
