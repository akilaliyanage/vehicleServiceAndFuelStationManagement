/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;
import com.oop.model.LoginAdminModel;

/**
 * @author mlaki
 *
 */
public class AdminLoginDAO {

	static Connection connection;
	static PreparedStatement pStatement;
	
	public LoginAdminModel getAdmin(String uname, String pwd) {
		
		LoginAdminModel adminModel = new LoginAdminModel();
		
		try {
			
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT username,userPassword,regNo FROM vehicleserviceandfuelstationmanagement.user where userName = ? and userPassword = ? and regNo like 'ADM%'");
			pStatement.setString(1, uname);
			pStatement.setString(2, pwd);
			
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				adminModel.setUsernameString(rSet.getString("username"));
				adminModel.setPasswordString(rSet.getString("userPassword"));
				adminModel.setRegnoString(rSet.getString("regNo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return adminModel;
	} 
}
