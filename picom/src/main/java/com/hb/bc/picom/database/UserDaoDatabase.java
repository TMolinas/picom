package com.hb.bc.picom.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.hb.bc.picom.database.*;
import com.hb.bc.picom.database.User;
import com.hb.bc.picom.dao.UserDao;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.sql.Date;

public class UserDaoDatabase implements UserDao {

	private PreparedStatement readStatement;
	
	public void create(User aUser) {
		Connection aConnection = ConnectionSingleton.getConnection();
		try {
			
			readStatement = aConnection.prepareStatement("INSERT INTO user ( user_first_name, user_last_name, user_email, user_passwd, user_phone, id_city) VALUES ( ?, ?, ?, ?, ?, ?)");
			//aPreparedStmt.setInt(1, aUser.getId());
			readStatement.setString(1, aUser.getFirstName());
			readStatement.setString(2, aUser.getLastName());
			readStatement.setString(3, aUser.getEmail());
			readStatement.setString(4, aUser.getPassword());
			readStatement.setString(5, aUser.getPhone());
			readStatement.setInt(6, aUser.getIdCity());
			//aPreparedStmt.setDate(7, aUser.getDateInscription());

			readStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}

	public User read(int id) {
		User user = new User();
		Connection aConnection = ConnectionSingleton.getConnection();
		Statement aStatement;
		try {
			aStatement = aConnection.createStatement();
			ResultSet aResultSet = aStatement.executeQuery("SELECT * FROM user WHERE user_id=" + id);
			ResultSetMetaData aMetaData = aResultSet.getMetaData();	
			if (aResultSet.next()) {
				user.setId(aResultSet.getInt("user_id"));
				user.setFirstName(aResultSet.getString("user_first_name"));
				user.setLastName(aResultSet.getString("user_last_name"));
				user.setEmail(aResultSet.getString("user_email"));
				user.setPhone(aResultSet.getString("user_phone"));
				user.setPassword(aResultSet.getString("user_passwd"));
				user.setIdCity(aResultSet.getInt("id_city"));
				user.setDateInscription(aResultSet.getDate("user_date_inscription"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

	public void update(User aUser){
		Connection aConnection = ConnectionSingleton.getConnection();
		try {
			readStatement = aConnection.prepareStatement("UPDATE user SET user_first_name=?, user_last_name=?, user_email=?, user_passwd=?, user_phone=?, id_city=? WHERE user_id=?");
			readStatement.setString(1, aUser.getFirstName());
			readStatement.setString(2, aUser.getLastName());
			readStatement.setString(3, aUser.getEmail());
			readStatement.setString(4, aUser.getPassword());
			readStatement.setString(5, aUser.getPhone());
			readStatement.setInt(6, aUser.getIdCity());
			readStatement.setInt(7, aUser.getId());
			
			readStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(User aUser) {
		Connection aConnection = ConnectionSingleton.getConnection();
		Statement aStatement;
		try {
			aStatement = aConnection.createStatement();
			aStatement.execute("DELETE FROM user WHERE user_id=" + aUser.getId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
