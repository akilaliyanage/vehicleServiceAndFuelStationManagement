//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

/*
 * This Model class represents a package (ex : gold package) in the system
 * */

package com.oop.model;

public class PackageForAppoint {
	
	public String packId;
	public String adminRegNo;
	public String packType;
	public String packName;
	public Double price;
	public String packDescription;
	public String packImage;
	
	
	
	public PackageForAppoint() {
		super();
	}
	public PackageForAppoint(String packId, String adminRegNo, String packType, String packName, Double price,
			String packDescription, String packImage) {
		super();
		this.packId = packId;
		this.adminRegNo = adminRegNo;
		this.packType = packType;
		this.packName = packName;
		this.price = price;
		this.packDescription = packDescription;
		this.packImage = packImage;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPackDescription() {
		return packDescription;
	}
	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}
	public String getPackImage() {
		return packImage;
	}
	public void setPackImage(String packImage) {
		this.packImage = packImage;
	}
	
	

}
