package com.fiap.dindingo.service;

import java.sql.SQLException;

import com.fiap.dindingo.dao.UserDao;
import com.fiap.dindingo.model.User;

public class UserService {
	private UserDao dao;

	public UserService() {
		this.dao = new UserDao();
	}

	public void registerUser(String fullName, String email, String password) throws Exception {
		instanciateNewDao();

		User user = new User();
		user.setFullName(fullName);
		user.setEmail(email);
		user.setPassword(password);

		if (this.dao.isEmailDuplicated(email)) {
			throw new Exception("O Email já existe");
		} else {
			this.dao.register(user);
		}
	}

	public boolean login(String email, String password) throws SQLException {
		instanciateNewDao();

		if (this.dao.isLogged(email, password)) {
			return true;
		}
		return false;
	}

	private void instanciateNewDao() {
		if (this.dao == null) {
			this.dao = new UserDao();
		}
	}
}