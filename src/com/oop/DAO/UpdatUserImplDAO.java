/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oop.database.DatabaseConnection;
import com.oop.model.AppointmentDetailsModel;
import com.oop.model.BillDetailsModel;

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

			while (resultset.next()) {
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

	@Override
	public ArrayList<BillDetailsModel> getBillDetails(String regnoString) {
		// TODO Auto-generated method stub

		List<BillDetailsModel> bill = new ArrayList<BillDetailsModel>();

		try {

			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement(
					"select b.billId, p.paymentId,p.amount,p.paymentDateTime from Bill b , Payments p where b.paymentId = p.paymentId  and p.userRegNo = ?");
			pStatement.setString(1, regnoString);

			ResultSet rSet = pStatement.executeQuery();

			while (rSet.next()) {

				BillDetailsModel details = new BillDetailsModel();
				details.setBillIdString(rSet.getString("billId"));
				details.setPaymentIdString(rSet.getString("paymentId"));
				details.setAmountDouble(rSet.getDouble("amount"));
				details.setDateTimeString(rSet.getString("paymentDateTime"));

				bill.add(details);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return (ArrayList<BillDetailsModel>) bill;
	}

	@Override
	public ArrayList<AppointmentDetailsModel> getAppDetails(String regNoString) {
		// TODO Auto-generated method stub

		ArrayList<AppointmentDetailsModel> det = new ArrayList<AppointmentDetailsModel>();

		try {

			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement(
					"select appId,packname,status,rating,location,prefDate,prefTime,remarks,serviceName from appointment a, package p, service s where a.packID = p.packId and a.service_id = serviceId and a.userRegNo = ?");
			pStatement.setString(1, regNoString);

			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				AppointmentDetailsModel app = new AppointmentDetailsModel();
				app.setAppidString(resultSet.getString("appId"));
				app.setPacknameString(resultSet.getString("packname"));
				app.setStatuString(resultSet.getString("status"));
				app.setRating(resultSet.getInt("rating"));
				app.setLocationString(resultSet.getString("location"));
				app.setDateString(resultSet.getString("prefDate"));
				app.setTimeString(resultSet.getString("prefTime"));
				app.setRemarkString(resultSet.getString("remarks"));
				app.setSernameString(resultSet.getString("serviceName"));

				det.add(app);
				
				System.out.println(app.getAppidString());

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return det;
	}

	
	
	@Override
	public int getTotVehicles(String regNoString) {
		// TODO Auto-generated method stub
		
		int totVehicles = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.vehicle where userRegNo = ?");
			pStatement.setString(1, regNoString);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				totVehicles = resultSet.getInt("tot");
				System.out.println(totVehicles);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return totVehicles;
	}
	
	

	@Override
	public int getTotApp(String regNoString) {
		
		int totApps = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.appointment where userRegNo = ?");
			pStatement.setString(1, regNoString);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				totApps = resultSet.getInt("tot");
				System.out.println(totApps);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return totApps;
	}

	
	
	@Override
	public int totPay(String regNoString) {
	int totPay = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT sum(amount) as'tot' FROM vehicleserviceandfuelstationmanagement.payments where userRegNo = ?");
			pStatement.setString(1, regNoString);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				totPay = resultSet.getInt("tot");
				System.out.println(totPay);
				System.out.println("totpay"+totPay);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return totPay;
	}

	
	
	@Override
	public int totItesm(String regNoString) {

		int totItems = 0;

		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT count(*) as 'tot' FROM vehicleserviceandfuelstationmanagement.reguser_item where custId = ?");
			pStatement.setString(1, regNoString);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				totItems = resultSet.getInt("tot");
				System.out.println(totItems);
				System.out.println("totpay"+totItems);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return totItems;
	}

}
