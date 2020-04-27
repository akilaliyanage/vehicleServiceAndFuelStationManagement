/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewMechModel;

/**
 * @author mlaki
 *
 */
public class UpdateMechDAO {
	
	static Connection connection;
	static PreparedStatement preparedStatement;
	
	public ArrayList<String> updateMech(String unameString, String passwordString){
		
		ArrayList<String> models = new ArrayList<String>();
		NewMechModel mechModel = null;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM vehicleserviceandfuelstationmanagement.mechanic m, vehicleserviceandfuelstationmanagement.user u where m.regNo = u.regNo and u.userName = ? and u.userPassword = ? and u.regNo = 'MEC%'");
			preparedStatement.setString(1, unameString);
			preparedStatement.setString(2, passwordString);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				models.add(resultSet.getString("userName"));
				models.add(resultSet.getString("userEmail"));
				models.add(resultSet.getString("userPassword"));
				models.add(resultSet.getString("regNo"));
				models.add(resultSet.getString("userFullName"));
				models.add(resultSet.getString("gender"));
				models.add(resultSet.getString("userPhone"));
				models.add(Float.toString(resultSet.getFloat("basicSalary")));
				models.add(resultSet.getString("speciality"));
				models.add(Float.toString(resultSet.getFloat("experience")));
				models.add(Float.toString(resultSet.getFloat("workingHours")));
				
				//mechModel = new NewMechModel(resultSet.getString("userName"), resultSet.getString("userEmail"), resultSet.getString("userPassword"), resultSet.getString("regNo"));
				//mechModel.setFullnameString(resultSet.getString("userFullName"));
				//mechModel.setGenderString(resultSet.getString("gender"));
				//mechModel.setPhoneString(resultSet.getString("userPhone"));
				//mechModel.setSal(resultSet.getFloat("basicSalary"));
				//mechModel.setSpecString(resultSet.getString("speciality"));
				//mechModel.setEx();
				//mechModel.setWh();
				

				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return models;
		
	}
	
}
