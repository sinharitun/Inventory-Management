package com.learn.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String driverClassLoader= "com.mysql.cj.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://localhost:3306/inventorymanagement";
	private static final String user = "root";
	private static final String pass = "Nitte@071";
	
	public static Connection connentionEstablish() throws SQLException {
		
		try {
			Class.forName(driverClassLoader);
		} catch (ClassNotFoundException e) {
			System.err.println("Issue arise while loading the class");
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url,user,pass);
	}
	
	public static void closeResourses(AutoCloseable... resources) {
		for(AutoCloseable resource: resources) {
			if(resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					System.err.println("Resource not closed Issue Occured : -" + e.getMessage());
					
				}
			}
		}
	}

}

