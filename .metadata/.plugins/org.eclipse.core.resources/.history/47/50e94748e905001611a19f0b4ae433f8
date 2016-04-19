package org.priyanka.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection myConn;
	private static final String DB_NAME = "dbname”;
	private static final String DB_USERNAME = “myusername”;
	private static final String DB_PASSWORD = “mypassword”;
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	
	DatabaseConnection(){
	  try {
		  myConn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public Connection getMyConn() {
		return myConn;
	}
	
	

}
