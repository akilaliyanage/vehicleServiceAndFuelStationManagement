/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewUserModel;
import com.oop.servlet.AdminLoginServlet;

/**
 * @author mlaki
 *
 */
public class NewUserDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	static PreparedStatement pStatement2;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(NewUserDAO.class.getName());
	
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
			
			
			
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
		return status;
		
		
		
	}

}
