package com.fiap.dindingo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fiap.dindingo.model.Balance;

public class BalanceDao {
	private Connection conexao;

	public BalanceDao() {
		this.conexao = DbConnection.startConnection();
	}

	public void register(Balance balance) throws SQLException {
		String sql = "INSERT INTO balance (ID, BALANCE_VALUE, BALANCE_CATEGORY, BALANCE_DATE, USER_ID)"
				+ "VALUES (sq_expense.nextval, ?, ?, ?, ?)";
		try {
			checkConnection();
			PreparedStatement dbPrepareTable = conexao.prepareStatement(sql);

			dbPrepareTable.setDouble(1, balance.getValue());
			dbPrepareTable.setString(2, balance.getCategory());
			Date data = Date.valueOf(balance.getDate());
			dbPrepareTable.setDate(3, data);
			dbPrepareTable.setInt(4, balance.getUser().getId());

			dbPrepareTable.execute();

			dbPrepareTable.close();

			System.out.println("deu certo");

		} catch (SQLException e) {
			System.out.println("deu erro");
			e.printStackTrace();
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
