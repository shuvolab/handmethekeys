package com.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.engine.mediator.data.*;

/**
 * @author nyusu131
 *         <p>
 *         Install MySQL and configure Built Path with the driver included in lib folder and run the following queries:
 *         <p>
 *         CREATE DATABASE db_handmethekeys
 *         <p>
 *         CREATE TABLE `db_handmethekeys`.`tbl_user` (
 *         `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
 *         `username` VARCHAR(255) NOT NULL,
 *         `password` VARCHAR(255) NOT NULL,
 *         PRIMARY KEY (`ID`),
 *         UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
 *         UNIQUE INDEX `username_UNIQUE` (`username` ASC));
 *         <p>
 *         INSERT INTO tbl_user (username, password)
 *         VALUES ('test', 'test')
 */

public class Connection {

    private String JDBC_CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/db_handmethekeys";
    private String db_username = "root";
    private String db_password = "";

    /**
     * Get the user id based on the
     *
     * @param username
     * @param password
     * @return user id if pair exists or -1 if it does not
     */
    public int getuser_ID(String username, String password) {

        String q_SELECT_user_ID = "SELECT ID FROM tbl_user WHERE username = '" + username + "' AND password = '" + password + "'";
        int user_id = -1;
        java.sql.Connection con = null;
        System.out.println(q_SELECT_user_ID);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q_SELECT_user_ID);
            if (rs.wasNull()) {
                return user_id;
            } else {
                while (rs.next()) {
                    user_id = rs.getInt("ID");
                }
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



    /**
     * @param zipCode
     * @return
     */
    public ArrayList<Car> search(String zipCode, String startDate, String endDate) {
        String SELECT = "SELECT DISTINCT tbl_car.ID, tbl_car.Brand, tbl_car.Model, tbl_car.Year, tbl_car.zipcode, tbl_car.user_ID "
                + "FROM tbl_car, tbl_availability "
                + "WHERE tbl_car.zipcode LIKE '" + zipCode.substring(0, 3) + "%' AND "
                + "tbl_car.ID = tbl_availability.car_ID AND ("
                + "tbl_availability.START_DATE > '" + endDate
                + "' OR tbl_availability.END_DATE < '" + startDate + "')";
        System.out.println(SELECT);
        ArrayList<Car> cars = new ArrayList<Car>();
        ResultSet rs = runQuery(SELECT);
        try {
            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("ID"),
                        rs.getString("Brand"),
                        rs.getString("Model"),
                        rs.getString("Year"),
                        rs.getInt("zipcode"),
                        getUser(rs.getString("user_ID")));
                cars.add(car); //change ownerID to real name
                System.out.println(car.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cars;
    }


    private User getUser(String id) {
        String SELECT = "SELECT * FROM tbl_user WHERE ID = '" + id + "'";
        System.out.println(SELECT);
        ResultSet rs = runQuery(SELECT);
        User user = null;
        try {
            while (rs.next()) {
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
        System.out.println(SELECT);
        ResultSet rs = runQuery(SELECT);
        User user = null;
        try {
            while (rs.next()) {
                user = new User(rs.getInt("ID"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    public void deleteCar(Car car){
        String DELETE = "DELETE FROM tbl_car "
                + "WHERE "
                + " tbl_car.ID = '" + car.getID() +"'";
        System.out.println(DELETE);
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(DELETE);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateCar(String model, String year, String brand, int ownerID, int zip, int carID){
        String UPDATE = "UPDATE tbl_car "
                + "SET car.Model = '" +model
                + "', car.Year = '" +year
                + "', car.BRAND = '"+brand
                + "', car.user_id = '"+ownerID
                + "', car.zipcode = '"+zip
                + "' WHERE car.ID = '" + carID +"' ";
        System.out.println(UPDATE);
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(UPDATE);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addCar(Car car) {
        String INSERT = "INSERT INTO tbl_car(Model,YEAR,BRAND,user_id,zipcode) VALUES('"
                + car.getModel() + "','"
                + car.getYear() + "','"
                + car.getMake() + "','"
                + car.getOwner().getID() + "','"
                + car.getZip() + "')";
        System.out.println(INSERT);
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

    public void rentCar(String startDate, String endDate, Car car, User user) {
        String INSERT = "INSERT INTO tbl_availability(START_DATE, END_DATE, car_ID, user_ID) VALUES('"
                + startDate + "','"
                + endDate + "','"
                + car.getID() + "','"
                + user.getID() + "')";
        System.out.println(INSERT);
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
     * @param query
     * @return
     */
    private ResultSet runQuery(String query) {
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
        return null;
    }


    public void addUser(String username, String password) {
        String INSERT = "INSERT INTO tbl_user(username, password) VALUES('" + username + "','" + password + "')";
        java.sql.Connection con = null;
        System.out.println(INSERT);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_CONNECTION_URI, db_username, db_password);
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(INSERT);
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getRentedCars(User user) {
        String SELECT = "SELECT * FROM tbl_car, tbl_availability "
                + "WHERE tbl_availability.user_id = '" + user.getID() + "' "
                + "AND tbl_car.ID = tbl_availability.car_ID ";
        System.out.println(SELECT);
        ArrayList<Car> cars = new ArrayList<Car>();
        ResultSet rs = runQuery(SELECT);
        try {
            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("ID"),
                        rs.getString("Brand"),
                        rs.getString("Model"),
                        rs.getString("Year"),
                        rs.getInt("zipcode"),
                        getUser(rs.getString("user_ID")));
                cars.add(car);
                System.out.println(car.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Car> getListedCars(User user) {
        String SELECT = "SELECT * FROM tbl_car "
                + "WHERE tbl_car.user_ID = '" + user.getID() + "' ";
        System.out.println(SELECT);
        ArrayList<Car> cars = new ArrayList<Car>();
        ResultSet rs = runQuery(SELECT);
        try {
            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("ID"),
                        rs.getString("Brand"),
                        rs.getString("Model"),
                        rs.getString("Year"),
                        rs.getInt("zipcode"),
                        getUser(rs.getString("user_ID"))));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Car> getRandomCars(String startDate, String endDate) {
        String SELECT = "SELECT tbl_car.ID, tbl_car.Brand, tbl_car.Model, tbl_car.Year, tbl_car.zipcode, tbl_car.user_ID "
                + "FROM tbl_car, tbl_availability "
                + "WHERE tbl_car.ID = tbl_availability.car_ID AND ("
                + "tbl_availability.START_DATE > '" + endDate
                + "' OR tbl_availability.END_DATE < '" + startDate + "')";
        System.out.println(SELECT);
        ArrayList<Car> cars = new ArrayList<Car>();
        ResultSet rs = runQuery(SELECT);
        try {
            while (rs.next()) {
                cars.add(new Car(
                        rs.getInt("ID"),
                        rs.getString("Brand"),
                        rs.getString("Model"),
                        rs.getString("Year"),
                        rs.getInt("zipcode"),
                        getUser(rs.getString("user_ID")))); //change ownerID to real name
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cars;
    }

}
