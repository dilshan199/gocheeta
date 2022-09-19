package com.gocheeta.web.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gocheeta.web.model.Customer;
import com.gocheeta.web.services.CustomerServices;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	
	CustomerServices services;
	String message,successMessage,fullNameError,contactNoError,emailError,passwordError,userNameError,cPError;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        services = CustomerServices.customerServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/customer":
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals("submit")) {
			try {
				addCustomer(request, response);
			} catch (NoSuchAlgorithmException | ServletException | IOException e) {
				
			}
		}
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		clearMessage();
		
		String fullName = request.getParameter("fullName");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String userName = request.getParameter("userName");
		int stringPassword = Integer.parseInt(password);
		int stringCPassword = Integer.parseInt(confirmPassword);
		boolean formError = false;
		
		if(fullName.isEmpty()) {
			fullNameError = "This feild is requierd";
			formError = true;
			request.setAttribute("fullNameError", fullNameError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			String pattern = "^[A-Za-z . \\s]*$";
			Pattern p = Pattern.compile(pattern);
			Matcher matcher = p.matcher(fullName);
			boolean matcherFound = matcher.find();
			if(!matcherFound) {
				fullNameError = "Fullname can include letters,dot and whitespace only";
				formError = true;
				request.setAttribute("fullNameError", fullNameError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}
		}
		
		if(contactNo.isEmpty()) {
			contactNoError = "This feild is required";
			formError = true;
			request.setAttribute("contactNoError", contactNoError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			if(contactNo.length() != 11) {
				contactNoError = "Contact no must include 11 digits";
				formError = true;
				request.setAttribute("contactNoError", contactNoError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}
		}
		
		if(email.isEmpty()) {
			emailError = "This feild is required";
			formError = true;
			request.setAttribute("emailError", emailError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			String emailPattern = "^(.+)@(.+)$";
			Pattern ep = Pattern.compile(emailPattern);
			Matcher em = ep.matcher(email);
			boolean emf = em.find();
			if(!emf) {
				emailError = "Invalid email address";
				formError = true;
				request.setAttribute("emailError", emailError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}
		}
		
		if(password.isEmpty()) {
			passwordError = "This feild is required";
			formError = true;
			request.setAttribute("password", passwordError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			if(password.length() != 6) {
				passwordError = "Password must include 6 digits";
				formError = true;
				request.setAttribute("password", passwordError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}
		}
		
		if(confirmPassword.isEmpty()) {
			cPError = "This feild is required";
			formError = true;
			request.setAttribute("cPError", cPError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			if(confirmPassword.length() != 6) {
				cPError = "Confirm password must include 6 digits";
				formError = true;
				request.setAttribute("cPError", cPError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}else if(stringPassword != stringCPassword) {
				cPError = "Password did\'t match";
				formError = true;
				request.setAttribute("cPError", cPError);
				RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
				rd.forward(request, response);
			}
		}
		
		password = encryptPassword(password);
		
		if(userName.isEmpty()) {
			userNameError = "This feild is required";
			formError = true;
			request.setAttribute("userNameError",userNameError);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			Customer checkUser = new Customer();
			try {
				boolean exitUser = services.exitUser(userName);
				if(exitUser) {
					userNameError = "Username already exit";
					formError = true;
					request.setAttribute("userNameError",userNameError);
					RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
			}
		}
		
		if(formError) {
			message = "Can't create account";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}else {
			Customer customer = new Customer(fullName,contactNo,email,password,userName);
			try {
				boolean result = services.addCustomer(customer);
				if(result) {
					successMessage = "Account created successfully";
				}else {
					message = "Can't create account";
				}
			} catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			request.setAttribute("customer", customer);
			request.setAttribute("successMessage", successMessage);
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
			rd.forward(request, response);
		}
		
	}
	
	public String encryptPassword(String password) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] bytesValue = md.digest();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < bytesValue.length;i++) {
			 sb.append(Integer.toString((bytesValue[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return sb.toString();
	}
	
	public void clearMessage() {
		message = successMessage = fullNameError = contactNoError = emailError = passwordError = userNameError = cPError = "";
	}

}
