package com.fiap.dindingo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.Expense;
import com.fiap.dindingo.model.User;

public class ExpenseDao {

	private Connection conexao;

	public ExpenseDao() {
		this.conexao = DbConnection.startConnection();
	}

	public void register(Expense expense) throws SQLException {
		String sql = "INSERT INTO EXPENSE (ID, EXPENSE_VALUE, EXPENSE_CATEGORY, EXPENSE_DATE, USER_ID)"
				+ "VALUES (sq_expense.nextval, ?, ?, ?, ?)";
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
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
	}


	public List<Expense> getExpenses(User user) throws SQLException{
		List<Expense> expenses = new ArrayList<Expense>();
		
		String sql = "SELECT EXPENSE_VALUE, EXPENSE_CATEGORY, EXPENSE_DATE FROM EXPENSE WHERE USER_ID = ?)";
		
		try {
			checkConnection();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			
			ResultSet rs = preparedStatement.executeQuery(sql);

	        Statement stmts = (Statement) this.conexao.createStatement();

	        if (rs.next()) {
	            ResultSet data = stmts.executeQuery(sql);

	            while (data.next()) {
	            	Expense expense = new Expense();
	            	expense.setValue(data.getDouble("EXPENSE_VALUE"));
	            	expense.setCategory(data.getString("EXPENSE_CATEGORY"));
	            	expense.setDate(null);//data.getDate("EXPENSE_DATE")
	            	expense.setUser(user);
	            	expenses.add(expense);
	            }	          
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
		return expenses;
	}
	
	private void checkConnection() throws SQLException {
		if (this.conexao.isClosed()) {
			this.conexao = DbConnection.startConnection();
		}
	}

}
