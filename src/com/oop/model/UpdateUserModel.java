/**
 * 
 */
package com.oop.model;

import java.io.InputStream;

/**
 * @author mlaki
 *
 */
public class UpdateUserModel {
	
	private String nameString;
	private String phoneString;
	private String genderString;
	private String descriptionString;
	private String userIdString;
	/**
	 * @return the userIdString
	 */
	public String getUserIdString() {
		return userIdString;
	}
	/**
	 * @param userIdString the userIdString to set
	 */
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	/**
	 * @return the nameString
	 */
	public String getNameString() {
		return nameString;
	}
	/**
	 * @param nameString the nameString to set
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	/**
	 * @return the phoneString
	 */
	public String getPhoneString() {
		return phoneString;
	}
	/**
	 * @param phoneString the phoneString to set
	 */
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	/**
	 * @return the genderString
	 */
	public String getGenderString() {
		return genderString;
	}
	/**
	 * @param genderString the genderString to set
	 */
	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}
	/**
	 * @return the descriptionString
	 */
	public String getDescriptionString() {
		return descriptionString;
	}
	/**
	 * @param descriptionString the descriptionString to set
	 */
	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}
	@Override
	public String toString() {
		return "UpdateUserModel [nameString=" + nameString + ", phoneString=" + phoneString + ", genderString="
				+ genderString + ", descriptionString=" + descriptionString + "]";
	}
	
	
	
	

}
