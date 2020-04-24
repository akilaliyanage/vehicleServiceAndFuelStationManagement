package com.oop.packageModule.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ServicePackage {
	private String packId;
	private String adminRegNo;
	private String packType;
	private String packName;
	private float price;
	private String packDescription;
	private String packImage;

	public ServicePackage() {
	}

	public ServicePackage(String packId, String adminRegNo, String packType, String packName, float price,
			String packDescription) {
		this.packId = packId;
		this.adminRegNo = adminRegNo;
		this.packType = packType;
		this.packName = packName;
		this.price = price;
		this.packDescription = packDescription;
	}

	@Column(name = "packId", unique = true, nullable = false)
	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	@Column(name = "adminRegNo")
	public String getAdminRegNo() {
		return adminRegNo;
	}

	public void setAdminRegNo(String adminRegNo) {
		this.adminRegNo = adminRegNo;
	}

	@Column(name = "packType")
	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	@Column(name = "packName")
	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "packDescription")
	public String getPackDescription() {
		return packDescription;
	}

	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}

	@Column(name = "packImage")
	public String getPackImage() {
		return packImage;
	}

	public void setPackImage(String packImage) {
		this.packImage = packImage;
	}

	@Override
	public String toString() {
		return "ServicePackage [packId=" + packId + ", adminRegNo=" + adminRegNo + ", packType=" + packType
				+ ", packName=" + packName + ", price=" + price + ", packDescription=" + packDescription
				+ ", packImage=" + packImage + "]";
	}

}
