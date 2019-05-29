package com.internousdev.tktest.dto;

public class CategoryDTO {

	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private String registDate;
	private String updateDate;

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return this.categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
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
