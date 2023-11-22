package com.fiap.dindingo.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fiap.dindingo.dao.ExpenseDao;
import com.fiap.dindingo.model.Expense;

public class ExpenseService {

	private ExpenseDao dao;
	
	public ExpenseService() {
		this.dao = new ExpenseDao();
	}

	public void register(String value, String category, String date) throws SQLException {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");
		
		Expense expense = new Expense();
		expense.setValue(Double.parseDouble(value));
		expense.setCategory(category);
		expense.setDate(LocalDate.parse(date, dtf));
		
		dao.register(expense);
		
	}
}
