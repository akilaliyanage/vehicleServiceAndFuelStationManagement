package com.oop.model;

public class LoginModel {
	
	//local variables
	
	private String usernameString;
	private String passworString;
	private String regNoString;
	
	//creating setters and getters for the variables
	
	/**
	 * @return the regNoString
	 */
	public String getRegNoString() {
		return regNoString;
	}
	/**
	 * @param regNoString the regNoString to set
	 */
	public void setRegNoString(String regNoString) {
		this.regNoString = regNoString;
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
	
	
	@Override
	public String toString() {
		return "LoginModel [usernameString=" + usernameString + ", passworString=" + passworString + "]";
	}
		

}
