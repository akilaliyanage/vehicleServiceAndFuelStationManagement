package com.oop.model;

public class NewUserModel {
	
	protected String usernameString;
	protected String emailString;
	protected String passwordString;
	protected String userregNoString;
	
	
	
	
	
	public NewUserModel(String usernameString, String emailString, String passwordString, String userregNoString) {
		super();
		this.usernameString = usernameString;
		this.emailString = emailString;
		this.passwordString = passwordString;
		this.userregNoString = userregNoString;
	}
	/**
	 * @return the userregNoString
	 */
	public String getUserregNoString() {
		return userregNoString;
	}
	/**
	 * @param userregNoString the userregNoString to set
	 */
	public void setUserregNoString(String userregNoString) {
		this.userregNoString = userregNoString;
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
	 * @return the passwordString
	 */
	public String getPasswordString() {
		return passwordString;
	}
	
	
	/**
	 * @param passwordString the passwordString to set
	 */
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	
	@Override
	public String toString() {
		return "NewUserModel [usernameString=" + usernameString + ", emailString=" + emailString + ", passwordString="
				+ passwordString + "]";
	}
	
	
	
	

}
