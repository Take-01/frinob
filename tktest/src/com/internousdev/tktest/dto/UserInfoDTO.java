package com.internousdev.tktest.dto;

public class UserInfoDTO {
	
	private int id;
	private String userId;
	private String password;
	private String userName;
	private String email;
	private String registDate;
	private String updateDate;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRegistDate() {
		return this.registDate;
	}
	
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	
	public String getUpdateDate() {
		return this.updateDate;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
