package com.fiap.dindingo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.dindingo.service.UserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5067875123137825928L;

	private UserService service;

	public LoginServlet() {
		super();
		this.service = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("senha");
			boolean isLogged = this.service.login(email, password);

			if (isLogged) {
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/error.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}
}
