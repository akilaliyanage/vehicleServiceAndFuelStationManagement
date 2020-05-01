/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;

/**
 * @author mlaki
 *
 */
public class DeleteMechDAO {

	static Connection connection;
	static PreparedStatement preparedStatement;
	
	
	public int removeMech(String regnoString) {
		int rslt = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM `vehicleserviceandfuelstationmanagement`.`user` WHERE (`regNo` = ?)");
			preparedStatement.setString(1, regnoString);
			
			rslt = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rslt;
	}

}
