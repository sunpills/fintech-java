package com.fiap.dindingo.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.Expense;
import com.fiap.dindingo.service.BalanceService;
import com.fiap.dindingo.service.ExpenseService;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BalanceService balanceService;
	private ExpenseService expenseService;

	public HomeServlet() {
		super();
		this.balanceService = new BalanceService();
		this.expenseService = new ExpenseService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session=request.getSession();
			int userId= (Integer) session.getAttribute("userId");
			
			List<Balance> balances = balanceService.findBalancesBy(userId);
			request.setAttribute("balances", balances);
			
			List<Expense> expenses  =  expenseService.findExpensesBy(userId);
			request.setAttribute("expenses", expenses);
			
			//https://initialcommit.com/blog/how-to-send-data-from-servlet-to-jsp
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			e.printStackTrace();
		}
	}

}
