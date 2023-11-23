package com.fiap.dindingo.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fiap.dindingo.dao.ExpenseDao;
import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.Expense;
import com.fiap.dindingo.model.User;
import java.util.*;

public class ExpenseService {

	private ExpenseDao dao;

	public ExpenseService() {
		this.dao = new ExpenseDao();
	}

	public void register(String value, String category, String date, int userId) throws SQLException {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");

		Expense expense = new Expense();
		expense.setValue(Double.parseDouble(value));
		expense.setCategory(category);
		expense.setDate(LocalDate.parse(date, dtf));
		expense.setUser(new User(userId));
		dao.register(expense);

	}
	
	public List<Expense> findExpensesBy(int userId) throws SQLException {
		return dao.getExpenses(new User(userId));
	}
}
