package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.LoginModel;
import com.oop.servlet.AdminLoginServlet;

public class LoginDao {
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(LoginDao.class.getName());
	
	//getData() method to fetch and save data from the database to the LoginModel object
	
	@SuppressWarnings("unused")
	public LoginModel getData(String unameString, String passString) {
		
		LoginModel loginModel = new LoginModel();
		
		
		
		try {
			

			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT username,userPassword,regNo FROM vehicleserviceandfuelstationmanagement.user where userName = ? and userPassword = ? and regNo like 'REG%'");
			pStatement.setString(1, unameString);
			pStatement.setString(2, passString);
			Statement st = connection.createStatement();
			
			ResultSet resultSet =  pStatement.executeQuery();
			
			while (resultSet.next()) {
				
				loginModel.setUsernameString(resultSet.getString("userName"));
				loginModel.setPassworString(resultSet.getString("userPassword"));
				loginModel.setRegNoString(resultSet.getString("regNo"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	
		
		return loginModel;
	}

}
