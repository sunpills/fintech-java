package com.fiap.dindingo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import com.fiap.dindingo.model.User;

public class UserDao {
	
	private Connection conexao;
	
	public UserDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(User user) {
		String sql = "INSERT INTO fintech_user (ID, USER_NAME, USER_EMAIL, USER_PASSWORD)"
				+ "VALUES (sq_fintech_user.nextval, ?, ?, ?)";
		
		try {
			PreparedStatement dbPrepareTable = conexao.prepareStatement(sql);
			
			dbPrepareTable.setString(1, user.getFullName());
			dbPrepareTable.setString(2, user.getEmail());
			dbPrepareTable.setString(3, user.getPassword());
			
			dbPrepareTable.execute();
			
			dbPrepareTable.close();
			conexao.close();
			
			System.out.println("deu certo");
			
		} catch (SQLException e) {
			System.out.println("deu erro");
			e.printStackTrace();
		}
	}
	
	public void delete(User user) {
		
	}
	
}
