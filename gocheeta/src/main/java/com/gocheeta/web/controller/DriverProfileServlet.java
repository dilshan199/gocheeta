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
import javax.servlet.http.HttpSession;

import com.gocheeta.web.model.DBooking;
import com.gocheeta.web.model.DLogin;
import com.gocheeta.web.services.DBookingServices;

/**
 * Servlet implementation class DriverProfileServlet
 */
public class DriverProfileServlet extends HttpServlet {
	
	DBookingServices services;
	String message;
	int listSize;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverProfileServlet() {
    	services = DBookingServices.dBookingServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/confirm":
			confirmBooking(request, response);
			break;
		case "/complete":
			completeBooking(request, response);
			break;
		case "/cancel":
			cancelBooking(request, response);
			break;
		case "/readmore":
			getSelectedBooking(request, response);
			break;
			default:
				getAllBooking(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals("confirm")) {
			confirmBooking(request, response);
		}else if(type.equals("complete")) {
			completeBooking(request, response);
		}else {
			cancelBooking(request, response);
		}
	}
	
	private void getAllBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		
		HttpSession session = request.getSession(false);
		DLogin di = (DLogin) session.getAttribute("dl");
		if(di != null) {
			int driverId = di.getDriverId();
			List<DBooking> bookingList;
			try {
				bookingList = services.getBooking(driverId);
				listSize = bookingList.size();
			} catch (ClassNotFoundException | SQLException e) {
				bookingList = new ArrayList<DBooking>();
			}
			request.setAttribute("bookingList", bookingList);
			request.setAttribute("listSize", listSize);
			RequestDispatcher rd = request.getRequestDispatcher("driver-profile.jsp");
			rd.forward(request, response);
		}
	}
	
	private void getSelectedBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		DBooking  booking = new DBooking();
		try {
			booking = services.getSelectedBooking(bookingId);
		} catch (ClassNotFoundException | SQLException e) {
			booking = new DBooking();
		}
		HttpSession bookingSession = request.getSession();
		bookingSession.setAttribute("booking", booking);
		response.sendRedirect("read-more.jsp");
	}
	
	private void confirmBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		int vehicleStatus = Integer.parseInt(request.getParameter("vehicleStatus"));
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		DBooking cb = new DBooking();
		DBooking us = new DBooking(vehicleId, vehicleStatus);
		try {
			boolean result1 = services.confirmBooking(bookingId);
			boolean result2 = services.updateVehicle(us);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("cb", cb);
		request.setAttribute("us", us);
		RequestDispatcher rd = request.getRequestDispatcher("read-more.jsp");
		rd.forward(request, response);
	}
	
	private void completeBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		int vehicleStatus = Integer.parseInt(request.getParameter("vehicleStatus"));
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		DBooking cb = new DBooking();
		DBooking us = new DBooking(vehicleId, vehicleStatus);
		try {
			boolean result1 = services.completeBooking(bookingId);
			boolean result2 = services.updateVehicle(us);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("cb", cb);
		request.setAttribute("us", us);
		RequestDispatcher rd = request.getRequestDispatcher("read-more.jsp");
		rd.forward(request, response);
		
	}
	
	private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		int vehicleStatus = Integer.parseInt(request.getParameter("vehicleStatus"));
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		DBooking cb = new DBooking();
		DBooking us = new DBooking(vehicleId, vehicleStatus);
		try {
			boolean result1 = services.cancelBooking(bookingId);
			boolean result2 = services.updateVehicle(us);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("cb", cb);
		request.setAttribute("us", us);
		RequestDispatcher rd = request.getRequestDispatcher("read-more.jsp");
		rd.forward(request, response);
	}
	
	public void clearMessage() {
		message = "";
	}

}
