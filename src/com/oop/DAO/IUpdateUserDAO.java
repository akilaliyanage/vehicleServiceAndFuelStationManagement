/**
 * 
 */
package com.oop.DAO;

import java.util.ArrayList;

import com.oop.model.AppointmentDetailsModel;
import com.oop.model.BillDetailsModel;
import com.oop.model.PurchaseFuelModel;

/**
 * @author mlaki
 *
 */
public interface IUpdateUserDAO {
	
		//get the user details
		public ArrayList<String> getUserDetails(String regNoString);
		
		//gets the bill details of the logged user
		public ArrayList<BillDetailsModel> getBillDetails(String regnoString);
		
		//gets the appointments details of the logged user
		public ArrayList<AppointmentDetailsModel> getAppDetails(String regNoString);
		
		//gets the total hehicle detils of the user
		public int getTotVehicles(String regNoString);
		
		//gets the total number of appointments of the user
		public int getTotApp(String regNoString);
		
		//gets the totals payments
		public int totPay(String regNoString);
		
		//gets the total itesm purchased
		public int totItesm(String regNoString);
		
		public float paid(String regnoString);
		
		public float pending(String regnoString);
		
		//return the fuel dispenser id
		public ArrayList<String> disId();
		
		//return the fuel usage
		public ArrayList<PurchaseFuelModel> returnPurchase(String regnoString);
}
