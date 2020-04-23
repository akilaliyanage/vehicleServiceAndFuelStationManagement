/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewUserModel;

/**
 * @author mlaki
 *
 */
public class NewUserDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	static PreparedStatement pStatement2;
	
	public int insertdata(NewUserModel newUser) {
		
		int status = 0;
		int status2= 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("insert into vehicleserviceandfuelstationmanagement.User(regNo,userName,userPassword,userEmail) values(?,?,?,?)");
			pStatement2 = connection.prepareStatement("insert into registeredCustomer(customerRegId) values(?)");
			pStatement2.setString(1, newUser.getUserregNoString());
			pStatement.setString(1, newUser.getUserregNoString());
			pStatement.setString(2, newUser.getUsernameString());
			pStatement.setString(3, newUser.getPasswordString());
			pStatement.setString(4, newUser.getEmailString());
			
			status = pStatement.executeUpdate();
			status2 = pStatement2.executeUpdate();
			
			System.out.println(status2);
			
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return status;
		
		
		
	}

}
