package com.fiap.dindingo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

import com.fiap.dindingo.model.Expense;
import com.fiap.dindingo.model.User;

public class ExpenseDao {

	private Connection conexao;
	
	public ExpenseDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(Expense expense) {
		String sql = "INSERT INTO EXPENSE (ID, EXPENSE_VALUE, EXPENSE_CATEGORY, EXPENSE_DATE, USER_ID)" +
				"VALUES (sq_expense.nextval, ?, ?, ?, ?)";
		try {
			
			PreparedStatement dbPrepareTable = conexao.prepareStatement(sql);
		
			dbPrepareTable.setDouble(1, expense.getExpenseValue());
			dbPrepareTable.setString(2, expense.getExpenseCategory());
			Date data = Date.valueOf(expense.getExpenseDate());
			dbPrepareTable.setDate(3, data);
			dbPrepareTable.setInt(4, expense.getUser().getId());
			
			dbPrepareTable.execute();
			
			dbPrepareTable.close();
			conexao.close();
			
			
			System.out.println("deu certo");
			
		} catch (SQLException e) {
			System.out.println("deu erro");
			e.printStackTrace();
		}
	}
	
	
	
	
}
