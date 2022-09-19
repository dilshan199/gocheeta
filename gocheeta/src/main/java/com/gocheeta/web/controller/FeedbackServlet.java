package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gocheeta.web.model.Feedback;
import com.gocheeta.web.services.FeedbackServices;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	
	FeedbackServices services;
	String errorMessage, successMessage, messageError;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        services = FeedbackServices.feedbackServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/feedback":
			getBookingId(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals(type)) {
			addFeedback(request, response);
		}
	}
	
	private void getBookingId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		Feedback feedback = new Feedback();
		try {
			feedback = services.getBookingId(bookingId);
		} catch (ClassNotFoundException | SQLException e) {
			feedback = new Feedback();
		}
		HttpSession session = request.getSession();
		session.setAttribute("feedback", feedback);
		response.sendRedirect("feedback.jsp");
	}
	
	private void addFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		
		int cId = Integer.parseInt(request.getParameter("cId"));
		String message = request.getParameter("message");
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		boolean formError = false;
		
		if(message.isEmpty()) {
			messageError ="This feild is required";
			formError = true;
			request.setAttribute("messageError", messageError);
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			rd.forward(request, response);
		}
		
		if(formError) {
			errorMessage = "Feedback not saved";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			rd.forward(request, response);
		}else {
			Feedback feedback = new Feedback();
			Feedback saveFeedback = new Feedback(bookingId, cId, message);
			try {
				boolean result = services.addFeedback(saveFeedback);
				boolean result2 = services.updateStatus(bookingId);
				if(result && result2) {
					successMessage = "Feedback successfully saved";
				}else {
					errorMessage = "Can\'t save your feedback";
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("saveFeedback", saveFeedback);
			request.setAttribute("successMessage", successMessage);
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			rd.forward(request, response);
		}
	}
	
	public void clearMessage() {
		errorMessage = successMessage = messageError = "";
	}

}
