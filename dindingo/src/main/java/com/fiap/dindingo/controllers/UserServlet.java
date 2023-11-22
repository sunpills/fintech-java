package com.fiap.dindingo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.dindingo.service.UserService;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService service;

    public UserServlet() {
        super();
        this.service = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obter parâmetros do formulário
            String fullName = request.getParameter("nome");
            String lastName = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String password = request.getParameter("senha");
            
            service.registerUser(fullName + " " + lastName, email, password);
	        // Redirecionar para a página de sucesso
	        response.sendRedirect(request.getContextPath() + "/home.jsp");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
    }
}
