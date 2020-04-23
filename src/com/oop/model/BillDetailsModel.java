package com.oop.model;

public class BillDetailsModel {
	
	//class variables
	
	private String billIdString;
	private String paymentIdString;
	private String dateTimeString;
	private Double amountDouble;
	/**
	 * @return the billIdString
	 */
	public String getBillIdString() {
		return billIdString;
	}
	/**
	 * @param billIdString the billIdString to set
	 */
	public void setBillIdString(String billIdString) {
		this.billIdString = billIdString;
	}
	/**
	 * @return the paymentIdString
	 */
	public String getPaymentIdString() {
		return paymentIdString;
	}
	/**
	 * @param paymentIdString the paymentIdString to set
	 */
	public void setPaymentIdString(String paymentIdString) {
		this.paymentIdString = paymentIdString;
	}
	/**
	 * @return the dateTimeString
	 */
	public String getDateTimeString() {
		return dateTimeString;
	}
	/**
	 * @param dateTimeString the dateTimeString to set
	 */
	public void setDateTimeString(String dateTimeString) {
		this.dateTimeString = dateTimeString;
	}
	/**
	 * @return the amountDouble
	 */
	public Double getAmountDouble() {
		return amountDouble;
	}
	/**
	 * @param amountDouble the amountDouble to set
	 */
	public void setAmountDouble(Double amountDouble) {
		this.amountDouble = amountDouble;
	}
	@Override
	public String toString() {
		return "BillDetailsModel [billIdString=" + billIdString + ", paymentIdString=" + paymentIdString
				+ ", dateTimeString=" + dateTimeString + ", amountDouble=" + amountDouble + "]";
	}
	
	
}
