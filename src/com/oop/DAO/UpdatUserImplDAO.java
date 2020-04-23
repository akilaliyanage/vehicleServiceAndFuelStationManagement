/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;

/**
 * @author mlaki
 *
 */
public class UpdatUserImplDAO implements IUpdateUserDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;

	@Override
	public ArrayList<String> getUserDetails(String regNoString) {
		// TODO Auto-generated method stub
		
		ArrayList<String> detailsArrayList = new ArrayList<String>();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("select * from User where regNo = ?");
			pStatement.setString(1, regNoString);
			
			ResultSet resultset = pStatement.executeQuery();
			
			while(resultset.next()) {
				detailsArrayList.add(resultset.getString("regNo"));
				detailsArrayList.add(resultset.getString("userName"));
				detailsArrayList.add(resultset.getString("userPhone"));
				detailsArrayList.add(resultset.getString("userEmail"));
				detailsArrayList.add(resultset.getString("userFullName"));
				detailsArrayList.add(resultset.getString("gender"));
				detailsArrayList.add(resultset.getString("Userdescription"));
				detailsArrayList.add(resultset.getString("userImage"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return detailsArrayList;
	}


}
