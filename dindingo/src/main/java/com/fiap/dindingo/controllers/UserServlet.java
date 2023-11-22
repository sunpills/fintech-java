package com.fiap.dindingo.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fiap.dindingo.service.UserService;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public UserServlet() {
        super();
        this.userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obter parâmetros do formulário
        String fullName = request.getParameter("nome");
        String lastName = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String password = request.getParameter("senha");

        System.out.print(fullName + lastName + email + password);
        // Lógica de cadastro com interação no serviço UserService
        try {
			userService.registerUser(fullName + " " + lastName, email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Redirecionar para a página de sucesso
        response.sendRedirect(request.getContextPath() + "/home.jsp");
    }
}
