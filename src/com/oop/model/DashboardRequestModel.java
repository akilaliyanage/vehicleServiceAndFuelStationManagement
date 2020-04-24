/**
 * 
 */
package com.oop.model;

/**
 * @author mlaki
 *
 */
public class DashboardRequestModel {
	
	private String servicenameString;
	private String userimageString;
	private String statuString;
	private String locationString;
	private String usernameString;
	private String appidString;
	/**
	 * @return the servicenameString
	 */
	public String getServicenameString() {
		return servicenameString;
	}
	/**
	 * @param servicenameString the servicenameString to set
	 */
	public void setServicenameString(String servicenameString) {
		this.servicenameString = servicenameString;
	}
	/**
	 * @return the userimageString
	 */
	public String getUserimageString() {
		return userimageString;
	}
	/**
	 * @param userimageString the userimageString to set
	 */
	public void setUserimageString(String userimageString) {
		this.userimageString = userimageString;
	}
	/**
	 * @return the statuString
	 */
	public String getStatuString() {
		return statuString;
	}
	/**
	 * @param statuString the statuString to set
	 */
	public void setStatuString(String statuString) {
		this.statuString = statuString;
	}
	/**
	 * @return the locationString
	 */
	public String getLocationString() {
		return locationString;
	}
	/**
	 * @param locationString the locationString to set
	 */
	public void setLocationString(String locationString) {
		this.locationString = locationString;
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
	 * @return the appidString
	 */
	public String getAppidString() {
		return appidString;
	}
	/**
	 * @param appidString the appidString to set
	 */
	public void setAppidString(String appidString) {
		this.appidString = appidString;
	}
	@Override
	public String toString() {
		return "DashboardRequestModel [servicenameString=" + servicenameString + ", userimageString=" + userimageString
				+ ", statuString=" + statuString + ", locationString=" + locationString + ", usernameString="
				+ usernameString + ", appidString=" + appidString + "]";
	}
	
	
	
	
}
