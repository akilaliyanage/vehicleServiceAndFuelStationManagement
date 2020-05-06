/**
 * 
 */
package com.oop.DAO;

import java.util.ArrayList;
import java.util.List;
import com.oop.model.*;

/**
 * @author mlaki
 *
 */
public interface IUpdateDashboardDAO {
	
	//gets the request details of the user
	public ArrayList<DashboardRequestModel> getRequestDetails();
	
	//get the total number of customers
	public int totCustomers();
	
	//get the total income
	public int paidAmm();
	
	//get the total income
	public int pendingAmm();
	
	
	public int totApps();
	
	public int totPay();
	
	public int totPack();
	
	public ArrayList<RequestModel> req();
	
	public ArrayList<DashboardPaymentsDAO> pay();
	
	public ArrayList<NewMechModel> mech();
	
	public ArrayList<UpdateUserModel> user();
	
	public ArrayList<PurchaseFuelModel> adminusageArrayList();
	
	
}
