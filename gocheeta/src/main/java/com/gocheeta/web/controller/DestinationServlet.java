package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gocheeta.web.model.Destination;
import com.gocheeta.web.services.DestinationServices;
import com.google.gson.Gson;

/**
 * Servlet implementation class DestinationServlet
 */
public class DestinationServlet extends HttpServlet {
	
	DestinationServices services;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinationServlet() {
        services = DestinationServices.destinationServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		
		Destination destination = new Destination();
		try {
			
			destination = services.getDestination(street, city);
			Gson json = new Gson();
			String d = json.toJson(destination);
			response.setContentType("text/html");
			response.getWriter().write(d);
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
