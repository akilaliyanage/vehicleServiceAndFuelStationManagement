package com.oop.model;

public class PaymentModel {

	String idString;
	float total;
	/**
	 * @return the idString
	 */
	public String getIdString() {
		return idString;
	}
	/**
	 * @param idString the idString to set
	 */
	public void setIdString(String idString) {
		this.idString = idString;
	}
	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PaymentModel [idString=" + idString + ", total=" + total + "]";
	}
	
	

}
