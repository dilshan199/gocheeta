package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gocheeta.web.model.Home;
import com.gocheeta.web.services.HomeServices;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	
	HomeServices services;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        services = HomeServices.homeServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/index":
			category(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void category(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Home> catList;
		List<Home> feedbackList;
		
		try {
			catList = services.getCategory();
			feedbackList = services.feedback();
		} catch (ClassNotFoundException | SQLException e) {
			catList = new ArrayList<Home>();
			feedbackList = new ArrayList<Home>();
		}
		HttpSession homeSession = request.getSession();
		homeSession.setAttribute("catList", catList);
		homeSession.setAttribute("feedbackList", feedbackList);
		response.sendRedirect("index.jsp");
	}

}
