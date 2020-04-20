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
}
