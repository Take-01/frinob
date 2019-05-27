package com.internousdev.tktest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/tktest";
	private static String user = "root";
	private static String password = "KT%my-SQL01";

	public Connection getConnection() {

		Connection con = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}
