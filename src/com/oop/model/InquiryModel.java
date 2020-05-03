package com.oop.model;


public class InquiryModel {

	private String inqidString;
	private String typeString;
	private String usermessageString;
	private String adminmessageString;
	private String adminidString;
	private String useridString;
	/**
	 * @return the inqidString
	 */
	public String getInqidString() {
		return inqidString;
	}
	/**
	 * @param inqidString the inqidString to set
	 */
	public void setInqidString(String inqidString) {
		this.inqidString = inqidString;
	}
	/**
	 * @return the typeString
	 */
	public String getTypeString() {
		return typeString;
	}
	/**
	 * @param typeString the typeString to set
	 */
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	/**
	 * @return the usermessageString
	 */
	public String getUsermessageString() {
		return usermessageString;
	}
	/**
	 * @param usermessageString the usermessageString to set
	 */
	public void setUsermessageString(String usermessageString) {
		this.usermessageString = usermessageString;
	}
	/**
	 * @return the adminmessageString
	 */
	public String getAdminmessageString() {
		return adminmessageString;
	}
	/**
	 * @param adminmessageString the adminmessageString to set
	 */
	public void setAdminmessageString(String adminmessageString) {
		this.adminmessageString = adminmessageString;
	}
	/**
	 * @return the adminidString
	 */
	public String getAdminidString() {
		return adminidString;
	}
	/**
	 * @param adminidString the adminidString to set
	 */
	public void setAdminidString(String adminidString) {
		this.adminidString = adminidString;
	}
	/**
	 * @return the useridString
	 */
	public String getUseridString() {
		return useridString;
	}
	/**
	 * @param useridString the useridString to set
	 */
	public void setUseridString(String useridString) {
		this.useridString = useridString;
	}
	@Override
	public String toString() {
		return "InquiryModel [inqidString=" + inqidString + ", typeString=" + typeString + ", usermessageString="
				+ usermessageString + ", adminmessageString=" + adminmessageString + ", adminidString=" + adminidString
				+ ", useridString=" + useridString + "]";
	}
	
	
	

}
