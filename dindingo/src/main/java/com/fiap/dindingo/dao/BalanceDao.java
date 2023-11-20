package com.fiap.dindingo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

import com.fiap.dindingo.model.Balance;

public class BalanceDao {
	private Connection conexao;
	
	public BalanceDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void register(Balance balance) {
		String sql = "INSERT INTO balance (ID, BALANCE_VALUE, BALANCE_CATEGORY, BALANCE_DATE, USER_ID)" +
				"VALUES (sq_expense.nextval, ?, ?, ?, ?)";
		try {
			PreparedStatement dbPrepareTable = conexao.prepareStatement(sql);
			
			dbPrepareTable.setDouble(1, balance.getBalanceValue());
			dbPrepareTable.setString(2, balance.getBalanceCategory());
			Date data = Date.valueOf(balance.getBalanceDate());
			dbPrepareTable.setDate(3, data);
			dbPrepareTable.setInt(4, balance.getUser().getId());
			
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
