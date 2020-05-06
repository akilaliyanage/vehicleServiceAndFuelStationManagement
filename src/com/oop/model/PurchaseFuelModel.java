/**
 * 
 */
package com.oop.model;

/**
 * @author mlaki
 *
 */
public class PurchaseFuelModel {

	private String disidString;
	private String useridString;
	private float amount;
	private String puridString;
	/**
	 * @return the puridString
	 */
	public String getPuridString() {
		return puridString;
	}
	/**
	 * @param puridString the puridString to set
	 */
	public void setPuridString(String puridString) {
		this.puridString = puridString;
	}
	/**
	 * @return the disidString
	 */
	public String getDisidString() {
		return disidString;
	}
	/**
	 * @param disidString the disidString to set
	 */
	public void setDisidString(String disidString) {
		this.disidString = disidString;
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
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PurchaseFuelModel [disidString=" + disidString + ", useridString=" + useridString + ", amount=" + amount
				+ ", puridString=" + puridString + "]";
	}
	
	
	
	

}
