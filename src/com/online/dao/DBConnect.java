package com.online.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.online.model.Login;
import com.online.model.Registration;


public class DBConnect {
	private static Connection connection = null;
	private static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static String DATABASE_NAME = "ejproj";
	private static String DB_URL = "jdbc:mysql://localhost:3306/"
			+ DBConnect.DATABASE_NAME;
	private static String USER_NAME = "root";
	private static String PASSWORD = "root";

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER_NAME);
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME,
					PASSWORD);
			return con;
		} catch (ClassNotFoundException cne) {
			System.out.println(cne);
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
		return con;
	}

	public void closeConnection() {
		try {

			if (connection != null)
				connection.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
	}

	public boolean checkLogin(Login login) {
		String SQL = "select username,password from login where username='"
				+ login.getUserName() + "' and password='" + login.getPassword()
				+ "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;
				else
					result = Boolean.FALSE;
				closeConnection();
			} else {
				System.out.println("Connection is null in checkLogin");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in checkLogin - " + sqle);
		}
		return result;
	}

	public boolean isAlreadyExists(String name) {
		String SQL = "select name from category where name='" + name + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in isAlreadyExists");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in isAlreadyExists - " + sqle);
		}
		return result;
	}

	public boolean addCategory(String name) {
		String SQL = "insert into category(name) values('" + name + "')";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in addCategory");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in addCategory - " + sqle);
		}
		return result;

	}

	public boolean isItemAlreadyExists(String itemName) {
		String SQL = "select name from item where name='" + itemName + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in isItemAlreadyExists");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in isItemAlreadyExists - " + sqle);
		}
		return result;
	}
	
	
	public boolean registartion(Registration reg) {
		PreparedStatement preparedStatement= null;
		String SQL = "insert into login(username,email,password) values (?,?,?)"; 
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				 preparedStatement = connection.prepareStatement(SQL);
				 preparedStatement.setString(1, reg.getUsername());
	             preparedStatement.setString(2, reg.getEmail());
	             preparedStatement.setString(3, reg.getPassword());
	             
	             int i= preparedStatement.executeUpdate(); 
	             
	             if (i!=0)
						result = Boolean.TRUE;
					else
						result = Boolean.FALSE;
					closeConnection();
			} else {
				System.out.println("Connection is null in Registration");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in Registration - " + sqle);
		}
		return result;
	}
	             
}
