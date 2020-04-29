package com.oop.purchaseItemModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Item {

	private String itemId;
	private String itemname;
	private String itemType;
	private float quantity;
	private float price;
	private String itemImage;

	@Column(name = "packId", unique = true, nullable = false)
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Column(name = "itemname")
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "itemType")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "quantity")
	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "itemImage")
	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	
	

}
