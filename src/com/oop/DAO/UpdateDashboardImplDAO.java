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
				pStatement = connection.prepareStatement("SELECT a.appId , a.status, a.location, s.serviceName,u.userFullName, u.userImage  from Appointment a, User u, Service s, registeredcustomer r where a.service_id = s.serviceId and a.userRegNo = r.customerRegId and r.customerRegId = u.regNo");
				//Statement st = connection.createStatement();
				
				ResultSet rsResultset = pStatement.executeQuery();
				
				while(rsResultset.next()) {
					DashboardRequestModel drm = new DashboardRequestModel();
					
					drm.setAppidString(rsResultset.getString("appId"));
					drm.setStatuString(rsResultset.getString("status"));
					drm.setLocationString(rsResultset.getString("location"));
					drm.setServicenameString(rsResultset.getString("serviceName"));
					drm.setUsernameString(rsResultset.getString("userFullName"));
					drm.setUserimageString(rsResultset.getString("userImage"));
										
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
				pStatement = connection.prepareStatement("SELECT COUNT(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.registeredcustomer");
				//Statement st = connection.createStatement();
				
				ResultSet resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					tot = resultSet.getInt("tot");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(tot);
			
			return tot;
		}

}
