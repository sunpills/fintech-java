package com.fiap.dindingo.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.dindingo.service.BalanceService;

public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BalanceService service;

	public BalanceServlet() {
		super();
		this.service = new BalanceService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String value = request.getParameter("expense_value");
		String category = request.getParameter("expense_category");
		String date = request.getParameter("expense_date");

		try {
			service.register(value, category, date);
			response.sendRedirect(request.getContextPath() + "/home.jsp");
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			e.printStackTrace();
		}
	}

}
