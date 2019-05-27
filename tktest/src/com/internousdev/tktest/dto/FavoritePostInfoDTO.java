package com.internousdev.tktest.dto;

public class FavoritePostInfoDTO {

	private int id;
	private String userId;
	private int favPostId;
	private String postTag;
	private String favRegistDate;
	private String favUpdateDate;
	private String writerId;
	private String title;
	private String body;
	private String imageFilePath;
	private String imageFileName;
	private String postRegistDate;
	private String postUpdateDate;

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

	public int getFavPostId() {
		return this.favPostId;
	}

	public void setFavPostId(int favPostId) {
		this.favPostId = favPostId;
	}

	public String getPostTag() {
		return this.postTag;
	}

	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}

	public String getFavRegistDate() {
		return this.favRegistDate;
	}

	public void setFavRegistDate(String favRegistDate) {
		this.favRegistDate = favRegistDate;
	}

	public String getFavUpdateDate() {
		return this.favUpdateDate;
	}

	public void setFavUpdateDate(String favUpdateDate) {
		this.favUpdateDate = favUpdateDate;
	}

	public String getWriterId() {
		return this.writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageFilePath() {
		return this.imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return this.imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getPostRegistDate() {
		return this.postRegistDate;
	}

	public void setPostRegistDate(String postRegistDate) {
		this.postRegistDate = postRegistDate;
	}

	public String getPostUpdateDate() {
		return this.postUpdateDate;
	}

	public void setPostUpdateDate(String postUpdateDate) {
		this.postUpdateDate = postUpdateDate;
	}

}
