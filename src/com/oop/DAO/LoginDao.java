package com.oop.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.oop.database.DatabaseConnection;
import com.oop.model.LoginModel;

public class LoginDao {
	
	//getData() method to fetch and save data from the database to the LoginModel object
	
	public LoginModel getData(String unameString, String passString) {
		
		LoginModel loginModel = new LoginModel();
		
		Connection connection;
		String query = "SELECT * FROM login.login";
		
		try {
			
			connection = DatabaseConnection.getConnection();
//			pStatement = connection.prepareStatement("select * from user where username=? and password=?");
//			pStatement.setString(1, unameString);
//			pStatement.setString(2, passString);
//			
//			Resultset resultset = (Resultset) pStatement.executeQuery();
//			
//			while (((ResultSet) resultset).next()) {
//				
//				
//			}
			
			Statement st = connection.createStatement();
			
			ResultSet resultSet =  st.executeQuery(query);
			
			while (resultSet.next()) {
				
				loginModel.setUsernameString(resultSet.getString("username"));
				loginModel.setPassworString(resultSet.getString("password"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
		}
		
		
	
		
		return loginModel;
	}

}
