package com.fiap.dindingo.service;

import java.sql.SQLException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fiap.dindingo.dao.BalanceDao;
import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.User;

public class BalanceService {

	private BalanceDao dao;

	public BalanceService() {
		this.dao = new BalanceDao();
	}

	public void register(String value, String category, String date, int userId) throws SQLException {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyy");

		Balance balance = new Balance();
		balance.setValue(Double.parseDouble(value));
		balance.setCategory(category);
		balance.setDate(LocalDate.parse(date, dtf));
		balance.setUser(new User(userId));

		dao.register(balance);

	}

	public List<Balance> findBalancesBy(int userId) throws SQLException {
		return dao.getBalances(new User(userId));
	}
}
