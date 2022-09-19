package com.gocheeta.web.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gocheeta.web.model.Login;
import com.gocheeta.web.services.LoginServices;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	LoginServices services;
	String message, userNameError, passwordError;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        services = LoginServices.loginServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/logout":
			logout(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		
		if(type.equals(type)) {
			try {
				login(request, response);
			} catch (NoSuchAlgorithmException | ServletException | IOException e) {
				
			}
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		clearMessage();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean formError = false;
		
		if(userName.isEmpty()) {
			userNameError = "This feild is required";
			formError = true;
			request.setAttribute("userNameError", userNameError);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			Login checkUserExit = new Login();
			try {
				boolean userExit = services.checkExitUser(userName);
				if(!userExit) {
					userNameError = "Username does\'t exit";
					formError = true;
					request.setAttribute("userNameError", userNameError);
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
			}
		}
		
		if(password.isEmpty()) {
			passwordError = "This feild is required";
			formError = true;
			request.setAttribute("passwordError", passwordError);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			if(password.length() != 6) {
				passwordError = "Password must include 6 digits";
				formError = true;
				request.setAttribute("passwordError", passwordError);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}else {
				password = encryptPassword(password);
				
				Login validatePassword = new Login();
				try {
					boolean passwordIsValid = services.passwordValidation(userName, password);
					if(!passwordIsValid) {
						passwordError = "Invalid password";
						formError = true;
						request.setAttribute("passwordError", passwordError);
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException e) {
					
				}
			}
		}
		
		if(formError) {
			message = "Login Failed";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			Login login = new Login();
			try {
				login = services.getUser(password);
			} catch (ClassNotFoundException | SQLException e) {
				login = new Login();
			}
			HttpSession loggedin = request.getSession();
			loggedin.setAttribute("login", login);
			response.sendRedirect("index");
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession loggedin = request.getSession(false);
		loggedin.invalidate();
		response.sendRedirect("index");
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
		message = userNameError = passwordError = "";
	}

}
