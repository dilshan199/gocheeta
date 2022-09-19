package com.gocheeta.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gocheeta.web.model.City;
import com.gocheeta.web.services.CityServices;
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	
	CityServices services;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        services = CityServices.cityServicesIns();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		City city = new City();
		String op = request.getParameter("operation");
		
		if(op.equals("city")) {
			int branchId = Integer.parseInt(request.getParameter("branchId"));
			List<City> cityList;
			try {
				
				cityList = services.getCities(branchId);
				Gson json = new Gson();
				String cl = json.toJson(cityList);
				response.setContentType("text/html");
				response.getWriter().write(cl);
				
			} catch (ClassNotFoundException | SQLException e) {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
