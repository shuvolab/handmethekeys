package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.engine.mediator.data.*;

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

	private String JDBC_CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/db_handmethekeys";
	private String db_username = "root";
	private String db_password = "";
	
	/**
	 * Get the user id based on the 
	 * @param username
	 * @param password
	 * @return user id if pair exists or -1 if it does not
	 */
	public int getUserId(String username, String password){
		
		String q_SELECT_USERID = "SELECT ID FROM tbl_user WHERE username = '" + username + "' AND password = '" + password + "'";
		int user_id = -1;
		java.sql.Connection con = null;
		
		try {
			
			ResultSet rs = runQuery(q_SELECT_USERID);
			if(rs==null||rs.wasNull())
			{
				return user_id;
			}
			rs.next();
			user_id = rs.getInt("ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_id;
	}
	
	/**
	 * Get a Car's info from the database by the id
	 * @param id
	 * @return car object constructed from the database if id match or a null object if it does not
	 */
	public Car getCar(int id){
		Car car = new Car();
		//database stuff
		return car;
	}
	
	private ResultSet runQuery(String query){
		 java.sql.Connection con = null;
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
			  java.sql.Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
			  return rs;
		  } catch (ClassNotFoundException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		return car;
	}
	
	/**
	 * @param zipCode
	 * @return
	 */
	public ArrayList<Car> search(String zipCode, String startDate, String endDate)
	{
		String SELECT = "SELECT tbl_car.ID, tbl_car.Brand, tbl_car.Model, tbl_car.Year, tbl_car.Zip, tbl_car.userID"
					  + "FROM tbl_car, tbl_availability "
					  + "WHERE tbl_car.zip LIKE '" + zipCode.substring(0, 3) + "%' AND "
					  + "tbl_car.ID = tbl_availability.car_ID AND ("
					  + "tbl_availability.START_DATE > '" + endDate 
					  + "' OR tbl_availability.END_DATE < '" + startDate + "')";
		ArrayList<Car> cars = new ArrayList<Car>();
		ResultSet rs = runQuery(SELECT);
		try {
			while(rs.next())
			{
				cars.add(new Car(
						rs.getInt("ID"),
						rs.getString("Brand"),
						rs.getString("Model"),
						rs.getString("Year"),
						rs.getInt("Zip"),
						getUser(rs.getString("OwnerID")))); //change ownerID to real name
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	private User getUser(String id) {
		String SELECT = "SELECT * FROM tbl_user WHERE ID = '" + id + "'";
		ResultSet rs = runQuery(SELECT);
		User user = null;
		try {
			while(rs.next())
			{
				user = new User(rs.getInt("ID"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	private User getUser(String name, String pwd) {
		String SELECT = "SELECT * FROM tbl_user WHERE username = '" + name + "','" + pwd + "'";
		ResultSet rs = runQuery(SELECT);
		User user = null;
		try {
			while(rs.next())
			{
				user = new User(rs.getInt("ID"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * adds a car to the database
	 * returns nothing as if something goes wrong exception is thrown
	 * @param car
	 */
	public void addCar(Car car)
	{
		String INSERT = "INSERT INTO tbl_car VALUES('"
				+ car.getModel()  + "','"
				+ car.getYear() + "','"
				+ car.getMake() + "','"
				+ car.getOwner().getID() + "','"
				+ ")";
		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rentCar(String startDate, String endDate, Car car)
	{
		String INSERT = "INSERT INTO tbl_availability VALUES('" 
						+ startDate + "','" 
						+ endDate + "','" 
						+ car.getOwner().getID() + "'";
		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	private ResultSet runQuery(String query){
		  java.sql.Connection con = null;
		  try {
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
		   java.sql.Statement stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(query);
		   con.close();
		   return rs;
		  } catch (ClassNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return null;
	}

	public void addUser(String username, String password)
	{
		String INSERT = "INSERT INTO tbl_user VALUES('" + username + "','" + password + "'";
		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
