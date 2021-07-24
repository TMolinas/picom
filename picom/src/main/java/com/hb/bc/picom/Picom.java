package com.hb.bc.picom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import org.json.*;
import com.hb.bc.picom.database.*;
import com.hb.bc.picom.dao.*;
import java.sql.Timestamp;

import com.hb.bc.picom.database.ConnectionSingleton;

import java.sql.Statement;
import java.sql.PreparedStatement;


public class Picom {
/*
	public static void testEnv(String[] args) throws Exception {
		InputStream aIn = Picom.class.getResourceAsStream("/env/app.env");
		Properties env = new Properties();
		
		env.load(aIn);
		
		String aBasePath = env.getProperty("basepath");
		System.out.println("basepath=" + aBasePath);
	}
	
	public static void main(String[] args) throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
	    conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
		                                   "user=root&password=");

	}
	

}
*/
	public static void main(String[] args) throws Exception {
		InputStream aIn = Picom.class.getResourceAsStream("/app.env");
		Properties env = new Properties();
		
		env.load(aIn);
		
		String aDbUrl = env.getProperty("db.url");
		String aDbName = env.getProperty("db.dbname");
		String aDbUserName = env.getProperty("db.username");
		String aDbUserPasswd = env.getProperty("db.passwd","");
		
		//Connection aConnection = DriverManager.getConnection(aDbUrl+"/"+aDbName, aDbUserName, aDbUserPasswd);
		
		
		//Connection aConnection = DriverManager.getConnection("jdbc:mysql://localhost/business_case?" + "user=root&password=");
		Connection aConnection = ConnectionSingleton.getConnection();
		
		Statement bStatement = aConnection.createStatement();
		//bStatement.executeUpdate("INSERT INTO admin VALUES(1,'Pseudo_admin', 'motdepasse1')");

		//bStatement.executeUpdate("INSERT INTO advertising VALUES('Macdonalds', 'www.macdonalds.com', 2021-07-20, 2021-07-30, 1)");
		PreparedStatement aPreparedStmt = aConnection.prepareStatement("UPDATE admin SET admin_username=?, admin_passwd=? WHERE admin_id=?");
		aPreparedStmt.setString(1, "admin_pseudo");
		aPreparedStmt.setString(2, "NewPasswd!");
		aPreparedStmt.setInt(3,1);
		aPreparedStmt.executeUpdate();
		
		
		Statement aStatement = aConnection.createStatement();
		showTable("user", aStatement);
		showTable("advertising", aStatement);
		
		UserDao userDao = new UserDaoDatabase();
		User user = userDao.read(2);
		System.out.println(user);
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//User user1 = new User("Peter", "Crochet", "PeefeferfCrochet@gmail.com", "motdepasse1", new Date(timestamp.getTime()), "0767565434");
		//user1.setIdCity(1);
		User user1 = userDao.read(6);
		System.out.println(user1);
		user1.setLastName("GrosJean");
		System.out.println(user1);

		userDao.update(user1);
		

		aStatement.close();
		aConnection.close();
		
		
		
	
	}
	
	public static void showTable(String table, Statement aStatement) throws Exception {
		ResultSet aResultSet = aStatement.executeQuery("SELECT * FROM " + table);
		
		ResultSetMetaData aMetaData = aResultSet.getMetaData();
		int aColumnsNumber = aMetaData.getColumnCount();
		
		while (aResultSet.next()) {
			for (int i = 1; i <= aColumnsNumber; i++) {
				if (i > 1) {
					System.out.print("|");
				}
				Object aColumnValue = aResultSet.getObject(i);
				System.out.print(aColumnValue);
			}
			System.out.println("");
		}
	}
		
	

}