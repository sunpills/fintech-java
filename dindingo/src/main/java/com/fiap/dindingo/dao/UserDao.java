package com.fiap.dindingo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.User;

public class UserDao {

	private Connection conexao;

	public UserDao() {
		this.conexao = DbConnection.startConnection();
	}

	public void register(User user) {
		String sql = "INSERT INTO fintech_user (ID, USER_NAME, USER_EMAIL, USER_PASSWORD)"
				+ "VALUES (sq_fintech_user.nextval, ?, ?, ?)";

		try {
			checkConnection();

			PreparedStatement dbPrepareTable = this.conexao.prepareStatement(sql);

			dbPrepareTable.setString(1, user.getFullName());
			dbPrepareTable.setString(2, user.getEmail());
			dbPrepareTable.setString(3, user.getPassword());

			dbPrepareTable.execute();

			dbPrepareTable.close();
			this.conexao.close();

			System.out.println("deu certo");

		} catch (SQLException e) {
			System.out.println("deu erro");
			e.printStackTrace();
		}
	}

	public boolean isEmailDuplicated(String email) throws SQLException {

		try {
			checkConnection();
			PreparedStatement preparedStatement = this.conexao
					.prepareStatement("SELECT COUNT(*) FROM FINTECH_USER WHERE USER_EMAIL = ?");
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);

			return count > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao verificar o email: " + e.getMessage());
		} finally {
			this.conexao.close();
		}
	}

	public User getUser(String email, String password) throws SQLException {
		try {
			checkConnection();
			PreparedStatement preparedStatement = this.conexao
					.prepareStatement("SELECT ID, USER_NAME FROM FINTECH_USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			User user = new User();
			user.setId(resultSet.getInt("ID"));
			user.setFullName(resultSet.getString("USER_NAME"));
			
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao logar o usuário: " + e.getMessage());
		} finally {
			this.conexao.close();
		}
	}

	private void checkConnection() throws SQLException {
		if (this.conexao.isClosed()) {
			this.conexao = DbConnection.startConnection();
		}
	}
}
