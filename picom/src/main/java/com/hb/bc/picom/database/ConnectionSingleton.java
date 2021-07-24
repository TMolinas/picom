package com.hb.bc.picom.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class ConnectionSingleton {
		
	private static Connection instance = null;
	
	private ConnectionSingleton() {
	}
	
	public final static Connection getConnection() {
		if(ConnectionSingleton.instance == null) {
			synchronized (ConnectionSingleton.class) {
				if(ConnectionSingleton.instance == null) {
					try {
						ConnectionSingleton.instance = instance = DriverManager.getConnection("jdbc:mysql://localhost/business_case?" + "user=root&password=");
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		return ConnectionSingleton.instance;
	}
	
}
