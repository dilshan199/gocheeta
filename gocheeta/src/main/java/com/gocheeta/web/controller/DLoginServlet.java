package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gocheeta.web.model.DLogin;
import com.gocheeta.web.services.DLoginServices;

/**
 * Servlet implementation class DLoginServlet
 */
public class DLoginServlet extends HttpServlet {
	
	DLoginServices services;
	String message, nicError, passwordError;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DLoginServlet() {
        services = DLoginServices.dLoginServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/driverlogout":
			driverLogout(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals("submit")) {
			login(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clearMessage();
		String nic = request.getParameter("nic");
		String password = request.getParameter("password");
		boolean formError = false;
		
		DLogin dl = new DLogin();
		
		if(nic.isEmpty()) {
			nicError = "This feild is required";
			formError = true;
			request.setAttribute("nicError", nicError);
			RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
			rd.forward(request, response);
		}else {
			try {
				boolean exitUser = services.checkExitUser(nic);
				if(!exitUser) {
					nicError = "User not found";
					formError = true;
					request.setAttribute("nicError", nicError);
					RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
			}
		}
		
		if(password.isEmpty()) {
			passwordError = "This feild is required";
			formError = true;
			request.setAttribute("passwordError", passwordError);
			RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
			rd.forward(request, response);
		}else {
			if(password.length() != 10) {
				passwordError = "Password must include 10 digits";
				formError = true;
				request.setAttribute("passwordError", passwordError);
				RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
				rd.forward(request, response);
			}else {
				try {
					boolean validPassword = services.validatePassword(nic, password);
					if(!validPassword) {
						passwordError = "Invalid password";
						formError = true;
						request.setAttribute("passwordError", passwordError);
						RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
						rd.forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException e) {
					
				}
			}
		}
		
		if(formError) {
			message = "Login failed";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("driver-login.jsp");
			rd.forward(request, response);
		}else {
			try {
				dl = services.getUser(password);
			} catch (ClassNotFoundException | SQLException e) {
				dl = new DLogin();
			}
			HttpSession loginSession = request.getSession();
			loginSession.setAttribute("dl", dl);
			response.sendRedirect("driverprofile");
		}
	}
	
	private void driverLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession loginSession = request.getSession(false);
		loginSession.invalidate();
		response.sendRedirect("index");
	}
	
	public void clearMessage() {
		message = nicError = passwordError = "";
	}

}
