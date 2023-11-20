package com.fiap.dindingo.model;

import java.time.LocalDate;

public class Balance {

	private int id;
	private double balanceValue;
	private String balanceCategory;
	private LocalDate balanceDate;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}
	
	public double getBalanceValue() {
		return balanceValue;
	}
	public void setBalanceValue(double balanceValue) {
		this.balanceValue = balanceValue;
	}
	
	public String getBalanceCategory() {
		return balanceCategory;
	}
	public void setBalanceCategory(String balanceCategory) {
		this.balanceCategory = balanceCategory;
	}
	
	public LocalDate getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


}
