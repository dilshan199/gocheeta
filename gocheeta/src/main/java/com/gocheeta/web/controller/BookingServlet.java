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

import com.gocheeta.web.model.Booking;
import com.gocheeta.web.services.BookingServices;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	
	BookingServices services;
	String message, successMessage;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        services = BookingServices.bookingServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/placebooking":
			getSelectedVehicle(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals("submit")) {
			addBooking(request, response);
		}
	}
	
	private void addBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		int driverId = Integer.parseInt(request.getParameter("driverId"));
		int cId = Integer.parseInt(request.getParameter("cId"));
		String pickUp = request.getParameter("pickUp");
		String drop = request.getParameter("drop");
		String pickUpDate = request.getParameter("pickUpDate");
		double price = Double.parseDouble(request.getParameter("price"));
		
		Booking booking = new Booking(branchId,vehicleId,driverId,cId,pickUp,drop,pickUpDate,price);
		try {
			
			boolean result = services.addBooking(booking);
			if(result) {
				successMessage = "Your booking save successfully";
			}else {
				message = "Sorry! booking save unsuccesfully";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("booking", booking);
		request.setAttribute("successMessage", successMessage);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("place-booking.jsp");
		rd.forward(request, response);
	}
	
	private void getSelectedVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		Booking vehicle = new Booking();
		List<Booking> branchList;
		try {
			
			vehicle = services.getVehicle(vehicleId);
			branchList = services.branches();
			
		} catch (ClassNotFoundException | SQLException e) {
			vehicle = new Booking();
			branchList = new ArrayList<Booking>();
		}
		request.setAttribute("vehicle", vehicle);
		request.setAttribute("branchList", branchList);
		RequestDispatcher rd = request.getRequestDispatcher("place-booking.jsp");
		rd.forward(request, response);
	}
	
	public void clearMessage() {
		message = successMessage = "";
	}

}
