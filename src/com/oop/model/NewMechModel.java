package com.oop.model;

public class NewMechModel extends NewUserModel {

	public NewMechModel(String usernameString, String emailString, String passwordString, String userregNoString) {
		super(usernameString, emailString, passwordString, userregNoString);
		// TODO Auto-generated constructor stub
	}
	
	private String fullnameString;
	private String genderString;
	private String phoneString;
	private float sal;
	private String specString;
	private float ex;
	private float wh;
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
	 * @return the sal
	 */
	public float getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(float sal) {
		this.sal = sal;
	}
	/**
	 * @return the specString
	 */
	public String getSpecString() {
		return specString;
	}
	/**
	 * @param specString the specString to set
	 */
	public void setSpecString(String specString) {
		this.specString = specString;
	}
	/**
	 * @return the ex
	 */
	public float getEx() {
		return ex;
	}
	/**
	 * @param ex the ex to set
	 */
	public void setEx(float ex) {
		this.ex = ex;
	}
	/**
	 * @return the wh
	 */
	public float getWh() {
		return wh;
	}
	/**
	 * @param wh the wh to set
	 */
	public void setWh(float wh) {
		this.wh = wh;
	}
	

}
