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

	public User login(String email, String password) throws SQLException {
		instanciateNewDao();

		User user = this.dao.getUser(email, password);
		if (user!= null) {
			return user;
		}
		return null;
	}

	private void instanciateNewDao() {
		if (this.dao == null) {
			this.dao = new UserDao();
		}
	}
}