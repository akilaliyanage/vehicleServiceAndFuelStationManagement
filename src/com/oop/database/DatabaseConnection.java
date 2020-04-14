/**
 * 
 */
package com.oop.database;

import java.sql.*;

/**
 * @author mlaki
 *
 */
public class DatabaseConnection implements DatabaseInfo {
	
	static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
				//registering the mysql jdbc driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
				//creating the connection to the database
			
			con = DriverManager.getConnection(databaseUrlString, databaseUsernameString, databasePasswordString);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return con;		//returning the connection
		
	}
}
