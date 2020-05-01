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
	private String emailString;
	private String usernameString;
	private String passworString;
	
	
	
	/**
	 * @return the emailString
	 */
	public String getEmailString() {
		return emailString;
	}
	/**
	 * @param emailString the emailString to set
	 */
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	/**
	 * @return the usernameString
	 */
	public String getUsernameString() {
		return usernameString;
	}
	/**
	 * @param usernameString the usernameString to set
	 */
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	/**
	 * @return the passworString
	 */
	public String getPassworString() {
		return passworString;
	}
	/**
	 * @param passworString the passworString to set
	 */
	public void setPassworString(String passworString) {
		this.passworString = passworString;
	}
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
				+ genderString + ", descriptionString=" + descriptionString + ", userIdString=" + userIdString
				+ ", emailString=" + emailString + ", usernameString=" + usernameString + ", passworString="
				+ passworString + "]";
	}
	
	
	
	
	

}
