package com.fiap.dindingo;

import java.time.LocalDate;

import com.fiap.dindingo.dao.BalanceDao;
import com.fiap.dindingo.dao.DbConnection;
import com.fiap.dindingo.dao.ExpenseDao;
import com.fiap.dindingo.dao.UserDao;
import com.fiap.dindingo.model.Balance;
import com.fiap.dindingo.model.Expense;
import com.fiap.dindingo.model.User;

public class FintechApp {
	public static void main(String[] args) {
		
		User user = new User();
		user.setId(2);
		user.setFullName("Teste");
		user.setEmail("teste@teste.com");
		user.setPassword("teste");
		UserDao uDao = new UserDao();
		uDao.register(user);
		
		Expense expense = new Expense();
		expense.setId(2);
		expense.setExpenseValue(0);
		expense.setExpenseCategory("Alimentacao");
		expense.setExpenseDate(LocalDate.of(2023, 4, 12));
		expense.setUser(user);
		ExpenseDao eDao = new ExpenseDao(DbConnection.startConnection());
		eDao.register(expense);
		
		Balance balance = new Balance();
		expense.setId(2);
		balance.setBalanceValue(0);
		balance.setBalanceCategory("Apostas");
		balance.setBalanceDate(LocalDate.of(2023, 4, 12));
		expense.setUser(user);
		BalanceDao bDao = new BalanceDao(DbConnection.startConnection());
		bDao.register(balance);
		
	}
}
