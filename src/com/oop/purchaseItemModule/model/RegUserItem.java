package com.oop.purchaseItemModule.model;

//IT19120058
//Geethika L.W.S

public class RegUserItem {
	private String itemId; // private attributes or the instance variables declared
	private int quantity;
	private double totPrice;
	private String cartNo;
	private String custId;

	public String getItemId() { // getter methods to access the instance variables
		return itemId;
	}

	public void setItemId(String itemId) {//setter methods to set values to instance variables
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(double totPrice) {
		this.totPrice = totPrice;
	}

	public String getCartNo() {
		return cartNo;
	}

	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}
