package com.oop.packageModule.model;

public class ServicePackage {
	private String packId;
	private String adminRegNo;
	private String packType;
	private String packName;
	private float price;
	private String packDescription;

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

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	public String getAdminRegNo() {
		return adminRegNo;
	}

	public void setAdminRegNo(String adminRegNo) {
		this.adminRegNo = adminRegNo;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPackDescription() {
		return packDescription;
	}

	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}

	@Override
	public String toString() {
		return "ServicePackage{packId=" + packId + ", adminRegNo=" + adminRegNo + ", packType=" + packType
				+ ", packName=" + packName + ", price=" + price + ", packDescription=" + packDescription + "}";
	}

}
