package com.fiap.dindingo.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.User;
import java.sql.*;

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
	
	public List<Balance> getBalances(User user) throws SQLException{
		List<Balance> balances = new ArrayList<Balance>();
		
		String sql = "SELECT BALANCE_VALUE, BALANCE_CATEGORY, BALANCE_DATE FROM  balance WHERE USER_ID = ?)";
		
		try {
			checkConnection();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			
			ResultSet rs = preparedStatement.executeQuery(sql);

	        Statement stmts = (Statement) this.conexao.createStatement();

	        if (rs.next()) {
	            ResultSet data = stmts.executeQuery(sql);

	            while (data.next()) {
	            	Balance balance = new Balance();
	            	balance.setValue(data.getDouble("BALANCE_VALUE"));
	            	balance.setCategory(data.getString("BALANCE_CATEGORY"));
	            	balance.setDate(null);//data.getDate("BALANCE_DATE")
	            	balance.setUser(user);
	            	balances.add(balance);
	            }	          
	        }
	        
		} catch (SQLException e) {
			System.out.println("deu erro");
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
		return balances;
	}

	private void checkConnection() throws SQLException {
		if (this.conexao.isClosed()) {
			this.conexao = DbConnection.startConnection();
		}
	}
}
