package com.zhn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	
	private static final String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String CONN_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=bluetooth";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "52571314";
	
	public Connection getConnection() {
		try {
			Class.forName(CLASS_NAME);
			return DriverManager.getConnection(CONN_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()){
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void executeUpdate(String sql) {
		
		Connection connection = getConnection();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll(connection, statement, null);
	}
	
}
