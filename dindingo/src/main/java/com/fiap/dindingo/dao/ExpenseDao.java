package com.fiap.dindingo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fiap.dindingo.model.Expense;

public class ExpenseDao {

	private Connection conexao;
	
	public ExpenseDao() {
		this.conexao = DbConnection.startConnection();
	}
	
	public void register(Expense expense) throws SQLException {
		String sql = "INSERT INTO EXPENSE (ID, EXPENSE_VALUE, EXPENSE_CATEGORY, EXPENSE_DATE, USER_ID)" +
				"VALUES (sq_expense.nextval, ?, ?, ?, ?)";
		try {
			checkConnection();
			PreparedStatement dbPrepareTable = conexao.prepareStatement(sql);
		
			dbPrepareTable.setDouble(1, expense.getValue());
			dbPrepareTable.setString(2, expense.getCategory());
			Date data = Date.valueOf(expense.getDate());
			dbPrepareTable.setDate(3, data);
			dbPrepareTable.setInt(4, expense.getUser().getId());
			
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
