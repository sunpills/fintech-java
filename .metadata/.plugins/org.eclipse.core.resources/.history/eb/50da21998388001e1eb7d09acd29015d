package com.fiap.dindingo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "rm99681";
	private static final String SENHA = "220796";
	
	public static Connection startConnection() {
		
		Connection dbconnection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			dbconnection = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Connection with Oracle estabilished.");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
		} catch (SQLException e) {
			System.out.println("Connection Error.");
		}
		return dbconnection;
	}
}
