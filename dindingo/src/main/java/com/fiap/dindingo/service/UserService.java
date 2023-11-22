package com.fiap.dindingo.service;

import java.sql.SQLException;

import com.fiap.dindingo.dao.UserDao;
import com.fiap.dindingo.model.User;

public class UserService {
	private UserDao userDao;

	public UserService() {
	        this.userDao = new UserDao();
	    }

	    public void registerUser(String fullName, String email, String password) throws SQLException {
	    	if (userDao == null) {
	    		this.userDao = new UserDao();
	    	}
	    	
	    	User user = new User();
	    	user.setFullName(fullName);
	    	user.setEmail(email);
	    	user.setPassword(password);
	        
	        if (this.userDao.isEmailDuplicated(email)) {
	            System.out.println("E-mail já existe");
	        } else {
	        	this.userDao.register(user);
	        }
	    }
}