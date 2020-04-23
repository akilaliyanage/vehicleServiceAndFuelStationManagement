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

	
	
	@Override
	public ArrayList<BillDetailsModel> getBillDetails(String regnoString) {
		// TODO Auto-generated method stub
		
		List<BillDetailsModel> bill = new ArrayList<BillDetailsModel>();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("select b.billId, p.paymentId,p.amount,p.paymentDateTime from Bill b , Payments p where b.paymentId = p.paymentId  and p.userRegNo = ?");
			pStatement.setString(1, regnoString);
			
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				
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


}
