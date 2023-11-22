package com.fiap.dindingo.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiap.dindingo.service.ExpenseService;

public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ExpenseService service;

	public ExpenseServlet() {
		super();
		this.service = new ExpenseService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String value = request.getParameter("expense_value");
		String category = request.getParameter("expense_category");
		String date = request.getParameter("expense_date");

		try {
			HttpSession session=request.getSession();
			int userId= (Integer) session.getAttribute("userId");
			
			service.register(value, category, date, userId);
			response.sendRedirect(request.getContextPath() + "/home.jsp");
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			e.printStackTrace();
		}
	}

}
