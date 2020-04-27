package com.oop.model;

public class UpdateAdminModel {
	

	private String fullnameString;
	private String usernameString;
	private String emailString;
	private String passwordString;
	private String phoneString;
	private Float salFloat;
	/**
	 * @return the regnString
	 */
	public String getRegnString() {
		return regnString;
	}
	/**
	 * @param regnString the regnString to set
	 */
	public void setRegnString(String regnString) {
		this.regnString = regnString;
	}
	private String regnString;
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
	 * @return the salFloat
	 */
	public Float getSalFloat() {
		return salFloat;
	}
	/**
	 * @param salFloat the salFloat to set
	 */
	public void setSalFloat(Float salFloat) {
		this.salFloat = salFloat;
	}
	@Override
	public String toString() {
		return "UpdateAdminModel [fullnameString=" + fullnameString + ", usernameString=" + usernameString
				+ ", emailString=" + emailString + ", passwordString=" + passwordString + ", phoneString=" + phoneString
				+ ", salFloat=" + salFloat + ", regnString=" + regnString + "]";
	}
	
	
	
	
	
	
	
}
