/**
 * 
 */
package com.oop.model;

/**
 * @author mlaki
 *
 */

//this calss inherits from the newUserModel class

public class NewAdminModel extends NewUserModel{

	public NewAdminModel(String usernameString, String emailString, String passwordString, String userregNoString) {
		super(usernameString, emailString, passwordString, userregNoString);
		// TODO Auto-generated constructor stub
	}

	
	private String fullnameString;
	private String phoneString;
	private String genderString;
	private Float salaryFloat;
	/**
	 * @return the fullnameString
	 */
	public String getFullnameString() {
		return fullnameString;
	}
	/**
	 * @param fullnameString the fullnameString to set
	 */
	public void setFullnameString(String fullnameString) {
		this.fullnameString = fullnameString;
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
	 * @return the salaryFloat
	 */
	public Float getSalaryFloat() {
		return salaryFloat;
	}
	/**
	 * @param salaryFloat the salaryFloat to set
	 */
	public void setSalaryFloat(Float salaryFloat) {
		this.salaryFloat = salaryFloat;
	}
	
	
}
