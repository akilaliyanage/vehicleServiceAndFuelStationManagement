/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.TextSyntax;

import com.mysql.cj.protocol.Resultset;
import com.oop.database.DatabaseConnection;
import com.oop.model.DashboardPaymentsDAO;
import com.oop.model.DashboardRequestModel;
import com.oop.model.NewMechModel;
import com.oop.model.NewUserModel;
import com.oop.model.PurchaseFuelModel;
import com.oop.model.RequestModel;
import com.oop.model.UpdateUserModel;
//import com.sun.tools.javap.TryBlockWriter;

/**
 * @author mlaki
 *
 */
public class UpdateDashboardImplDAO implements IUpdateDashboardDAO {
	
	//creating the connection and the prepared statements
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(UpdateDashboardImplDAO.class.getName());
	
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
				
			}catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
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
				
			}catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
		
			return tot;
		}



		//get the total income
		@Override
		public int paidAmm() {
			int paid = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT sum(amount) as 'paid' FROM vehicleserviceandfuelstationmanagement.payments");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					paid = rSet.getInt("paid");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			
			return paid;
		}


		
		//get the total income

		@Override
		public int pendingAmm() {
			
			int pending = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("select sum(a.amount) as 'tot' from vehicleserviceandfuelstationmanagement.appointment a left join vehicleserviceandfuelstationmanagement.payments p on a.appId = p.appId where p.appId is null");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					pending = rSet.getInt("tot");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			
			return pending;
			
		}



		//get the total appointments and return
		@Override
		public int totApps() {
			
			
			int totApps = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.appointment;");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					totApps = rSet.getInt("tot");
					
				}
				
			}catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			} 
			
			
			return totApps;
			
		}


		//fetch and return the total paid amount
		@Override
		public int totPay() {
	
			int totpay = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.payments;");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					totpay = rSet.getInt("tot");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			
			return totpay;
			
		}


		//fetch and return the total number of packages
		@Override
		public int totPack() {
			
			
			int totPack = 0;
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.package;");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					totPack = rSet.getInt("tot");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			
			return totPack;
			
		}


		//fetch and return the request details of the requests as a array list
		@Override
		public ArrayList<RequestModel> req() {
			
			ArrayList<RequestModel> requestModels = new ArrayList<RequestModel>();
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT count(*) as 'tot', prefDate  FROM vehicleserviceandfuelstationmanagement.appointment group by prefDate");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					
					RequestModel obj = new RequestModel();
					obj.setCount(rSet.getInt("tot"));
					obj.setDateString(rSet.getString("prefDate"));
					
					requestModels.add(obj);
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			// TODO Auto-generated method stub
			return requestModels;
		}


		//fetch and return the paymnt details as a array list

		@Override
		public ArrayList<DashboardPaymentsDAO> pay() {
			
			ArrayList<DashboardPaymentsDAO> paymentsDAOs = new ArrayList<DashboardPaymentsDAO>();
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT p.paymentId, u.userFullName, p.amount,p.paymentDateTime,p.paid, p.pending, p.appId FROM payments p, User u, registeredcustomer r where r.customerRegId = u.regNo and p.userRegNo = r.customerRegId;");
				ResultSet resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					DashboardPaymentsDAO paymentsDAO = new DashboardPaymentsDAO();
					paymentsDAO.setPaymentidString(resultSet.getString("paymentId"));
					paymentsDAO.setUsernameString(resultSet.getString("userFullName"));
					paymentsDAO.setAmount(resultSet.getFloat("amount"));
					paymentsDAO.setDateString(resultSet.getString("paymentDateTime"));
					paymentsDAO.setPaid(resultSet.getFloat("paid"));
					paymentsDAO.setPending(resultSet.getFloat("pending"));
					paymentsDAO.setAppidString(resultSet.getString("appId"));
					
					paymentsDAOs.add(paymentsDAO);
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			return paymentsDAOs;
		}


		//fetch and return mechanicle details as a array list
		@Override
		public ArrayList<NewMechModel> mech() {
		
			ArrayList<NewMechModel> mech = new ArrayList<NewMechModel>();
			
			try {
				
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT u.userFullName,u.regNo, m.basicSalary, m.speciality, m.experience, m.workingHours, u.userPhone, u.userEmail FROM vehicleserviceandfuelstationmanagement.user u , vehicleserviceandfuelstationmanagement.mechanic m where u.regNo = m.regNo");
				ResultSet rSet = pStatement.executeQuery();
				
				while(rSet.next()) {
					
					NewMechModel mechModel = new NewMechModel(null, rSet.getString("userEmail"), null, null);
					mechModel.setFullnameString(rSet.getString("userFullName"));
					mechModel.setSal(rSet.getFloat("basicSalary"));
					mechModel.setSpecString(rSet.getString("speciality"));
					mechModel.setEx(rSet.getFloat("experience"));
					mechModel.setWh(rSet.getFloat("workingHours"));
					mechModel.setPhoneString(rSet.getString("userPhone"));
					mechModel.setUserregNoString(rSet.getString("regNo"));
					
					mech.add(mechModel);
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			return mech;
		}


		//fetch and return user details as a array list
		@Override
		public ArrayList<UpdateUserModel> user() {

			
			ArrayList<UpdateUserModel> userModels = new ArrayList<UpdateUserModel>();
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT * FROM vehicleserviceandfuelstationmanagement.user where regNo like 'REG%'");
				
				ResultSet resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					UpdateUserModel update = new UpdateUserModel(resultSet.getString("userName"), resultSet.getString("userEmail"), null, resultSet.getString("regNo"));
					update.setNameString(resultSet.getString("userFullName"));
					update.setPhoneString(resultSet.getString("userPhone"));
					update.setGenderString(resultSet.getString("gender"));
					
					userModels.add(update);
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			return userModels;
			
		}


		//fetch and return fuel details as a array list
		@Override
		public ArrayList<PurchaseFuelModel> adminusageArrayList() {
			// TODO Auto-generated method stub
			
			ArrayList<PurchaseFuelModel> usageArrayList = new ArrayList<PurchaseFuelModel>();
			
			try {
				
				connection = DatabaseConnection.getConnection();
				pStatement = connection.prepareStatement("SELECT PurchaseID, amount FROM vehicleserviceandfuelstationmanagement.user_dispenser");
				ResultSet resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					PurchaseFuelModel objFuelModel = new PurchaseFuelModel();
					objFuelModel.setPuridString(resultSet.getString("PurchaseID"));
					objFuelModel.setAmount(resultSet.getFloat("amount"));
					
					usageArrayList.add(objFuelModel);
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				LOGGER.log(Level.SEVERE,e.getMessage());
			} 
			catch (Exception e) {
				// TODO: handle exception 
				LOGGER.log(Level.SEVERE,e.getMessage());
				
			}
			
			return usageArrayList;
		}



		

}
