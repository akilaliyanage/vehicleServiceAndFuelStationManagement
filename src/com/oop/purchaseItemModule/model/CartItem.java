package com.oop.purchaseItemModule.model;

//IT19120058
//Geethika L.W.S

public class CartItem {
	private String itemId;
	private String itemname;
	private String itemType;
	private String quantity;
	private String price;
	private String itemImage;
	private String totPrice;
	private String $$hashKey;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(String totPrice) {
		this.totPrice = totPrice;
	}

	public String get$$hashKey() {
		return $$hashKey;
	}

	public void set$$hashKey(String $$hashKey) {
		this.$$hashKey = $$hashKey;
	}

}
