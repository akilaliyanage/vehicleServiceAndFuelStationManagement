/**
 * 
 */
package com.oop.DAO;

import java.util.ArrayList;

import com.oop.model.BillDetailsModel;

/**
 * @author mlaki
 *
 */
public interface IUpdateUserDAO {
	
		//get the user details
		public ArrayList<String> getUserDetails(String regNoString);
		
		public ArrayList<BillDetailsModel> getBillDetails(String regnoString);
}
