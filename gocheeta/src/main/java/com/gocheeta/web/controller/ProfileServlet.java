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

import com.gocheeta.web.model.Login;
import com.gocheeta.web.model.Profile;
import com.gocheeta.web.services.ProfileServices;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	
	ProfileServices services;
	String message;
	int listSize;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        services = ProfileServices.profileServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/profile":
			getBooking(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void getBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		
		HttpSession session = request.getSession(false);
		Login customerId = (Login) session.getAttribute("login");
		if(customerId != null) {
			int cId = customerId.getcId();
			List<Profile> bookingList;
			try {
				bookingList = services.getAllBooking(cId);
				listSize = bookingList.size();
			} catch (ClassNotFoundException | SQLException e) {
				bookingList = new ArrayList<Profile>();
			}
			request.setAttribute("bookingList", bookingList);
			request.setAttribute("listSize", listSize);
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
	}
	
	public void clearMessage() {
		message = "";
	}

}
