/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.oop.database.DatabaseConnection;
import com.oop.model.DashboardRequestModel;

/**
 * @author mlaki
 *
 */
public class UpdateDashboardImplDAO implements IUpdateDashboardDAO {
	
	//creating the connection and the prepared statements
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	//gets the request details of the user
		@SuppressWarnings("unused")
		public ArrayList<DashboardRequestModel> getRequestDetails(){
			
			ArrayList<DashboardRequestModel> details = new ArrayList<DashboardRequestModel>();
			
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("");
				Statement st = connection.createStatement();
				
				ResultSet rsResultset = pStatement.executeQuery();
				
				while(rsResultset.next()) {
					DashboardRequestModel drm = new DashboardRequestModel();
					drm.setUsernameString(rsResultset.getString(""));
					drm.setAppointmentIDString(rsResultset.getString(""));
					drm.setServiveTypeString(rsResultset.getString(""));
					
					details.add(drm);
				}
				
				connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception 
				System.out.println(e);
			}			
			//returns the details in the string format
			return details;
		}
		
		
		
		//get the total number of customers
		@SuppressWarnings("unused")
		public int totCustomers() {
			int tot = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("");
				Statement st = connection.createStatement();
				
				ResultSet resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					tot = resultSet.getInt("");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return tot;
		}

}
