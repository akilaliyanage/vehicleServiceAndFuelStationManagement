/**
 * 
 */
package com.oop.DAO;

import java.util.ArrayList;

/**
 * @author mlaki
 *
 */
public interface IUpdateUserDAO {
	
		//get the user details
		public ArrayList<String> getUserDetails(String regNoString);
}
