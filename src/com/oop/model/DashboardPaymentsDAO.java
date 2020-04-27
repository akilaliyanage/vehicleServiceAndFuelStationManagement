package com.oop.model;

public class DashboardPaymentsDAO {
	
	private String paymentidString;
	private String usernameString;
	private float amount;
	private String dateString;
	private float paid;
	private float pending;
	private String appidString;
	/**
	 * @return the paymentidString
	 */
	public String getPaymentidString() {
		return paymentidString;
	}
	/**
	 * @param paymentidString the paymentidString to set
	 */
	public void setPaymentidString(String paymentidString) {
		this.paymentidString = paymentidString;
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
	/**
	 * @return the dateString
	 */
	public String getDateString() {
		return dateString;
	}
	/**
	 * @param dateString the dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	/**
	 * @return the paid
	 */
	public float getPaid() {
		return paid;
	}
	/**
	 * @param paid the paid to set
	 */
	public void setPaid(float paid) {
		this.paid = paid;
	}
	/**
	 * @return the pending
	 */
	public float getPending() {
		return pending;
	}
	/**
	 * @param pending the pending to set
	 */
	public void setPending(float pending) {
		this.pending = pending;
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
		return "DashboardPaymentsDAO [paymentidString=" + paymentidString + ", usernameString=" + usernameString
				+ ", amount=" + amount + ", dateString=" + dateString + ", paid=" + paid + ", pending=" + pending
				+ ", appidString=" + appidString + "]";
	}
	
	
}
