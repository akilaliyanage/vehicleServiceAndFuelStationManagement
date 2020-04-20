/**
 * 
 */
package com.oop.model;

/**
 * @author mlaki
 *
 */
public class DashboardRequestModel {
	//variables
	
	private String usernameString;
	private String appointmentIDString;
	private String serviveTypeString;
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
	 * @return the appointmentIDString
	 */
	public String getAppointmentIDString() {
		return appointmentIDString;
	}
	/**
	 * @param appointmentIDString the appointmentIDString to set
	 */
	public void setAppointmentIDString(String appointmentIDString) {
		this.appointmentIDString = appointmentIDString;
	}
	/**
	 * @return the serviveTypeString
	 */
	public String getServiveTypeString() {
		return serviveTypeString;
	}
	/**
	 * @param serviveTypeString the serviveTypeString to set
	 */
	public void setServiveTypeString(String serviveTypeString) {
		this.serviveTypeString = serviveTypeString;
	}
	@Override
	public String toString() {
		return "DashboardRequestModel [usernameString=" + usernameString + ", appointmentIDString="
				+ appointmentIDString + ", serviveTypeString=" + serviveTypeString + "]";
	}
	
	
}
