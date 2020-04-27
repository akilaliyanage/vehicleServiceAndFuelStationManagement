/**
 * 
 */
package com.oop.model;

/**
 * @author mlaki
 *
 */
public class RequestModel {
	
	private int count;
	private String dateString;
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
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
	@Override
	public String toString() {
		return "RequestModel [count=" + count + ", dateString=" + dateString + "]";
	}
	
	
	
}
