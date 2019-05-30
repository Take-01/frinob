package xyz.frinob.dto;

public class FavoriteUserInfoDTO {

	private int id;
	private String userId;
	private String favUserid;
	private String userTag;
	private String registDate;
	private String updateDate;
	private String favUserName;

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

	public String getFavUserid() {
		return this.favUserid;
	}

	public void setFavUserid(String favUserid) {
		this.favUserid = favUserid;
	}

	public String getUserTag() {
		return this.userTag;
	}

	public void setUserTag(String userTag) {
		this.userTag = userTag;
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
	
	public String getFavUserName() {
		return this.favUserName;
	}

	public void setFavUserName(String favUserName) {
		this.favUserName = favUserName;
	}
}
