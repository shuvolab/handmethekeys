package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/**
 * 
 * @author nyusu131
 *		
 *    Install MySQL and configure Built Path with the driver included in lib folder and run the following queries:
 *   
 *	  CREATE DATABASE db_handmethekeys
 *
 *	  CREATE TABLE `db_handmethekeys`.`tbl_user` (
 *	  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
 *	  `username` VARCHAR(255) NOT NULL,
 *	  `password` VARCHAR(255) NOT NULL,
 *	  PRIMARY KEY (`ID`),
 *	  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
 *	  UNIQUE INDEX `username_UNIQUE` (`username` ASC));
 *		
 *	  INSERT INTO tbl_user (username, password)
 *    VALUES ('test', 'test')
 *    
 */

public class Connection 
{

	private String JDBC_CONNECTION_URI = "jdbc:mysql://localhost:3306/db_handmethekeys";
	
	public int getUserId(String username, String password){
		
		String q_SELECT_USERID = "SELECT ID FROM tbl_user WHERE username = '" + username + "' AND password = '" + password + "'";
		int user_id = -1;
		java.sql.Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_CONNECTION_URI, "root", "");
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q_SELECT_USERID);
			rs.next();
			user_id = rs.getInt("ID");
			if(rs.wasNull())
			{
				return user_id;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_id;
	}
	
}
