package com.oop.model;

public class UserModel {
	
	protected String regNo;
	protected String userName;
	protected String userPassword;
	protected String userPhone;
	protected String userEmail;
	protected String userFullName;
	protected String gender;
	protected String Userdescription;
	protected String userImage;
	protected String address_line_1;
	protected String address_line_2;
	
	public UserModel() {
		super();
	}

	public UserModel(String regNo, String userName, String userPassword, String userPhone, String userEmail,
			String userFullName, String gender, String userdescription, String userImage, String address_line_1,
			String address_line_2) {
		super();
		this.regNo = regNo;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userFullName = userFullName;
		this.gender = gender;
		Userdescription = userdescription;
		this.userImage = userImage;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserdescription() {
		return Userdescription;
	}

	public void setUserdescription(String userdescription) {
		Userdescription = userdescription;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	
	
	
	
	
}
