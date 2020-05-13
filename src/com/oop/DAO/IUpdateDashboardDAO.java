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
	
	//get the total appointments and return
	public int totApps();
	
	//fetch and return the total paid amount
	public int totPay();
	
	//fetch and return the total number of packages
	public int totPack();
	
	//fetch and return the request details of the requests as a array list
	public ArrayList<RequestModel> req();
	
	//fetch and return the paymnt details as a array list
	public ArrayList<DashboardPaymentsDAO> pay();
	
	//fetch and return mechanicle details as a array list
	public ArrayList<NewMechModel> mech();
	
	//fetch and return user details as a array list
	public ArrayList<UpdateUserModel> user();
	
	//fetch and return fuel details as a array list
	public ArrayList<PurchaseFuelModel> adminusageArrayList();
	
	
}
